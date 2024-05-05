package com.example.pemograman.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.pemograman.model.Product;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
}