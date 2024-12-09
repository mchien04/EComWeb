package vn.iostar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

	List<ProductOrder> findByUserId(Integer userId);
	
	ProductOrder findByOrderId(String orderId);

}
