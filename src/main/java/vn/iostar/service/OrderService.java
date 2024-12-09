package vn.iostar.service;

import java.util.List;


import vn.iotstar.model.OrderRequest;
import vn.iotstar.model.ProductOrder;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public ProductOrder updateOrderStatus(Integer id, String status);

	public List<ProductOrder> getAllOrders();

	public ProductOrder getOrdersByOrderId(String orderId);
}

import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest);

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public Boolean updateOrderStatus(Integer id, String status);

}

