package com.example.demo.exception;

public class EmployeeDoesNotExist extends Exception {
	
	private static final long serialVersionUID = 1L;
    private String Exception;
   
 
   

	public EmployeeDoesNotExist(String exception) {
		super();
		Exception = exception;
	}




	@Override
    public String getMessage() {
        return "message =>"+Exception;
    }

}
