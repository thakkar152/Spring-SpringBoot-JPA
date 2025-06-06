package com.restapi.allannotations.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.resetapi.allannotations.dto.ApiResponseWithMessage;
import com.restapi.allannotations.model.Item;
import com.restapi.allannotations.repository.ItemRepository;
import com.restapi.allannotations.service.ItemService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;

// refer notes for @Validated. It is used to apply validation to @PathVariable and @RequestParam. 
// cross origin specifically over here on class is for giving access to UI react port 5173. browser blocks request if 
// frontend and backend ports are differents. 

@RestController
@RequestMapping("/api/items")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	//Field injection.Preferabble is constructor injection by creating constructor of ItemController and taking ItemService as input. 
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public List<Item> getItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	@ResponseStatus(HttpStatus.OK) //refer notes for response status. 
	public Optional<Item> getItemByID(@PathVariable int id) {
		return itemRepository.findById(id);
	}
	
	@GetMapping("/getbyqueryparam")
	public Optional<Item> getItemByIDQueryParam(@RequestParam @Min(value = 3, message = "Should be greater than 3") int id) {
		return itemRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // returns 201.
	public Item createItems(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@PostMapping("/saveAll")
	@ResponseStatus(HttpStatus.CREATED) // returns 201.
	public List<Item> createMultipleItems(@RequestBody List<Item> items) {
		return itemRepository.saveAll(items);
	}
	
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable @Min(1) int id) {
		 itemRepository.deleteById(id);
	}
	
	//Works without @PathVariable id as well but its not a good practice. 
	//Whenever we want to update something we know its id. 
	// it can insert as well but we should not pass id in json body. 
	@PutMapping("/id/{id}/update")
	public Item updateItem(@PathVariable int id, @RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	
	//we can also update by first getting item by id and then updates its name and save item. 
	// another way is to implemente query like we did here. 
	@PatchMapping("/id/{id}/name/{name}")
	public int updateItemName(@PathVariable int id, @PathVariable String name) {
		return itemRepository.udpateItemName(id,name);
	}
	
	//=======================
	// examples of RESPONSE ENTITY. refer notes. 
	//=======================
	
	// Just a normal response entity method which splits out string. 
	@GetMapping("/hello")
	public  ResponseEntity<String>  sayHello(){
		return ResponseEntity.ok().body("Hello to you !!");
	}
	
	// This method is splitting out status just like @ResponseStatus along with actual body and header.. 
	// you can see that custom header in header section of response. 
	@GetMapping("/requiredresponse")
	public  ResponseEntity<List<Item>>  getItemsWithResponse(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "CustomHeaderValue");
		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(itemRepository.findAll());
	}
	
	// This method is splitting out -> Status, Body and message as well... No direct way to incorporate message. 
	//with error handling manual way as well. 
	@PostMapping("/responsewithmessage")
	public ResponseEntity<ApiResponseWithMessage> createItemsWithMessage(@RequestBody Item item) {
		
		if (item.getName().equalsIgnoreCase("RandomName")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseWithMessage("Item Name cannot be Random Name", null));
		}
		
		Item savedItem = itemRepository.save(item);
		
		ApiResponseWithMessage response = new ApiResponseWithMessage("Item Created Successfully !!", savedItem);
		return ResponseEntity.status(200).body(response);
	}
	
	
	//============================
	//LARGE RESPONSE DATA STRATEGIES get call  -- READ NOTES. 
	//============================

	//================
	//PAGINATION
	//==============
	
	
	//http://localhost:8080/api/items/paginated?page=0&size=10
	//subsequent call .. page = 1, then page =2 etc.. 
	//http://localhost:8080/api/items/paginated?page=1&size=10
	// Also note defaultValue below.. if no params are given then it will take 0th page and 10 size. 
	
	@GetMapping("/paginated")
    public ResponseEntity<Page<Item>> getPaginatedItems(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Item> items = itemRepository.findAll(pageable);
        return ResponseEntity.ok(items);
    }
	
	//====================
	//STREAMING
	//=====================
	
	@GetMapping("/stream")
	public ResponseEntity<StreamingResponseBody> streamItems() {
	    StreamingResponseBody stream = new StreamingResponseBody() {
	     	@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				PrintWriter writer = new PrintWriter(outputStream);
	            Iterable<Item> items = itemRepository.findAll(); // Fetch all items

	            for (Item item : items) {
	                writer.println("{ \"id\": " + item.getId() + ", \"name\": \"" + item.getName() + "\" }");
	                writer.flush(); // Flush ensures the data is sent in real time
	            }

	            writer.close();
				
			}
	    };

	    return ResponseEntity.ok()
	            .header("Content-Type", "application/json")
	            .body(stream);
	}

	
	//============================
		//LARGE *REQUEST* DATA STRATEGIES get call  -- READ NOTES. 
	//============================
	
	//==================
	// Async calling for request processing
	//====================
	
	@PostMapping("/saveall/async")
    public ResponseEntity<String> createItems(@RequestBody List<Item> items) {
		
		
		// here we are using thenAccept method. which will not wait for the result but whenever result is available it will just print 
		//that result. below sysout "Async task completed with result: Items saved successfully!" gets logged in eclipse once thread
		//sleep is done. But actual response that is "Item creation started asynchronously!" printed in postman immediately. 
		// for user to know the status of request, we can implement polling mechanism for them.. we can pass taskid to the user 
		//using which it can poll the result. Not implemented here. Its easy but. can as chat gpt. 
		// Other method instead of polling which we can use for client to know about status of request are : Websocket and callbackurl
		// Polling: The client can periodically check the status of the task.
		//WebSockets: The server can push updates to the client in real-time.
		//Callback URL (Webhooks): The server notifies the client when the task is complete.
		
		CompletableFuture<String> response = itemService.processItemsAsync(items);
		
        response.thenAccept(result -> {
            System.out.println("Async task completed with result: " + result); // Logging result or taking other actions
        });
        return ResponseEntity.accepted().body("Item creation started asynchronously!");
    }
	
	//====================
	// CORS - Cross Origin Request Sharing. Read notes. 
	//=======================
	
	// Just a normal response entity method which splits out string. 
	@GetMapping("/corstry")
	@CrossOrigin(origins = "http://example.com")
	public  ResponseEntity<String>  corsTry(){
		return ResponseEntity.ok().body("You have used correct domain to access me !!");
	}
	

}
