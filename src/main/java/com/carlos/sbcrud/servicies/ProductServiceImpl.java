package com.carlos.sbcrud.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.sbcrud.entities.Product;
import com.carlos.sbcrud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
       
        return (List<Product>) repository.findAll();
    }
    
    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        
        return repository.findById(id);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Product save(Product product) {
        
        return repository.save(product);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = repository.findById(id);
        productDb.ifPresent(p ->{
            repository.delete(p);
        });
        
        return productDb;
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        if(productOptional.isPresent()){
            Product productDb = productOptional.orElseThrow();

            productDb.setNombre(product.getNombre());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());

            return Optional.of(repository.save(productDb));
        }
        return productOptional;
    }
}
