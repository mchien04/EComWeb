package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
