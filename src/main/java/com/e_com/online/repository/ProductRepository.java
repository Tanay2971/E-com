package com.e_com.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_com.online.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
List <Product> findAllByCategory_Id(int id);
}