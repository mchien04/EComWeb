package vn.iostar.service;

import java.util.List;

import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;

public interface OrderService {
	
	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;
	
	public List<ProductOrder> getOrdersByUser(Integer userId);
	
	public ProductOrder updateOrderStatus(Integer id, String status);
	
	public List<ProductOrder> getAllOrders();
	
	public ProductOrder getOrdersByOrderId(String orderId);

}
