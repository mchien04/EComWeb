package vn.iostar.service;

import java.util.List;

import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest);

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public Boolean updateOrderStatus(Integer id, String status);

}
