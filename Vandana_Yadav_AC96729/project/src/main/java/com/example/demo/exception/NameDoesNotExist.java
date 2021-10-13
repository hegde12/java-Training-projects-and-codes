package com.example.demo.exception;

public class NameDoesNotExist extends Exception {
	
	private static final long serialVersionUID = 1L;
    private String Exception;
 
	public NameDoesNotExist(String exception) {
		super();
		Exception = exception;
	}


	@Override
    public String getMessage() {
        return "message =>"+Exception;
    }

}
