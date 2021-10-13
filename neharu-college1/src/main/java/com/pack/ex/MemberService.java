package com.pack.ex;
import java.util.*;

public class MemberService {
	HashMap<String,List<String>> details;
	public MemberService()
	{
		details=new HashMap<>();
		details.put("Gireesh",Arrays.asList("Ramayana","Mahabarata ") );
		details.put("hareesh",Arrays.asList("Ramayana","Mahabarata ") );
	}
	public List<String> findByName(String name)
	{
		return details.get(name);
	}
}
