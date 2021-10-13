package com.example.demo.exception;

public class AnniversaryDoesNotExist extends Exception {
	
	private static final long serialVersionUID = 1L;
    private String Exception;
   

	public AnniversaryDoesNotExist(String exception) {
		super();
		Exception = exception;
	}



	@Override
    public String getMessage() {
        return "message =>"+Exception;
    }

}
