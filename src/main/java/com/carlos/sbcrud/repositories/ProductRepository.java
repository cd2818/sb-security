package com.carlos.sbcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.sbcrud.entities.Product;


public interface ProductRepository extends CrudRepository<Product,Long>{

}
