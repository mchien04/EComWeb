package vn.iostar.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.domain.Page;

import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;
=======

import vn.iotstar.model.OrderRequest;
import vn.iotstar.model.ProductOrder;
>>>>>>> afec4ef84d587ed9fe9fbc1e8194792410eb0df2

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public ProductOrder updateOrderStatus(Integer id, String status);

	public List<ProductOrder> getAllOrders();

	public ProductOrder getOrdersByOrderId(String orderId);
<<<<<<< HEAD
	
	public Page<ProductOrder> getAllOrdersPagination(Integer pageNo,Integer pageSize);
}
=======
}

import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest);

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public Boolean updateOrderStatus(Integer id, String status);

}

>>>>>>> afec4ef84d587ed9fe9fbc1e8194792410eb0df2
