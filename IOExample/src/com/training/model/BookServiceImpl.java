package com.training.model;
import java.io.PrintWriter;

import com.training.iface.BookService;
import com.training.model.*;

public class BookServiceImpl implements BookService {

	@Override
	public boolean write(Book book) {
		// TODO Auto-generated method stub
		try(PrintWriter pw=new PrintWriter("Book.txt",true));
				
		return false;
	}

}
