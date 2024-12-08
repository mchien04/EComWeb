package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	public Cart findByProductIdAndUserId(Integer productId, Integer userId);
	
}
