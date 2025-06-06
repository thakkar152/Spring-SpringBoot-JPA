package com.resetapi.allannotations.dto;
		
public class ApiResponseWithMessage {
	
	private String message;
    private Object data;

    public ApiResponseWithMessage(String message, Object data) {
        this.message = message;
        this.data = data;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
