package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}
