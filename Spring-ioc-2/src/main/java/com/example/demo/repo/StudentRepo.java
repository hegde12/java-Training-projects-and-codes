package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.xml.bind.v2.model.core.ID;

public interface StudentRepo<T> extends JpaRepository<T, ID> {

}
