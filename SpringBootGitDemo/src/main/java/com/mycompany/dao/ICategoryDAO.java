package com.mycompany.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.entity.Category;

public interface ICategoryDAO extends CrudRepository<Category, Integer> {
	
	List<Category> findAll();
	Category findById(int id);

	
}
