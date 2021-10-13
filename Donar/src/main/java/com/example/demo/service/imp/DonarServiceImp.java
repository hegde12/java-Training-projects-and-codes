package com.example.demo.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Donar;
import com.example.demo.repository.DonarRepository;
import com.example.demo.service.DonarService;

@Service
public class DonarServiceImp implements DonarService{

	private DonarRepository repo;
	
	public DonarServiceImp(DonarRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public List<Donar> getAllDonars() {
		
		return repo.findAll();
	}

}
