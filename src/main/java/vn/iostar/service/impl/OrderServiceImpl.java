package vn.iostar.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import vn.iostar.model.Cart;
import vn.iostar.model.OrderAddress;
import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;
import vn.iostar.repository.CartRepository;
import vn.iostar.repository.ProductOrderRepository;
import vn.iostar.service.OrderService;
import vn.iostar.util.CommonUtil;
import vn.iostar.util.OrderStatus;
=======

import vn.iotstar.model.Cart;
import vn.iotstar.model.OrderAddress;
import vn.iotstar.model.OrderRequest;
import vn.iotstar.model.ProductOrder;
import vn.iotstar.repository.CartRepository;
import vn.iotstar.repository.ProductOrderRepository;
import vn.iotstar.service.OrderService;
import vn.iotstar.util.CommonUtil;
import vn.iotstar.util.OrderStatus;
>>>>>>> afec4ef84d587ed9fe9fbc1e8194792410eb0df2

import vn.iostar.model.Cart;
import vn.iostar.model.OrderAddress;
import vn.iostar.model.OrderRequest;
import vn.iostar.model.ProductOrder;
import vn.iostar.repository.CartRepository;
import vn.iostar.repository.ProductOrderRepository;
import vn.iostar.service.OrderService;
import vn.iostar.util.OrderStatus;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductOrderRepository orderRepository;

	@Autowired
	private CartRepository cartRepository;


	@Autowired
	private CommonUtil commonUtil;

	@Override
	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception {

	@Override
	public void saveOrder(Integer userid, OrderRequest orderRequest) {


		List<Cart> carts = cartRepository.findByUserId(userid);

		for (Cart cart : carts) {

			ProductOrder order = new ProductOrder();

			order.setOrderId(UUID.randomUUID().toString());
			order.setOrderDate(LocalDate.now());

			order.setProduct(cart.getProduct());
			order.setPrice(cart.getProduct().getDiscountPrice());

			order.setQuantity(cart.getQuantity());
			order.setUser(cart.getUser());

			order.setStatus(OrderStatus.IN_PROGRESS.getName());
			order.setPaymentType(orderRequest.getPaymentType());

			OrderAddress address = new OrderAddress();
			address.setFirstName(orderRequest.getFirstName());
			address.setLastName(orderRequest.getLastName());
			address.setEmail(orderRequest.getEmail());
			address.setMobileNo(orderRequest.getMobileNo());
			address.setAddress(orderRequest.getAddress());
			address.setCity(orderRequest.getCity());
			address.setState(orderRequest.getState());
			address.setPincode(orderRequest.getPincode());

			order.setOrderAddress(address);


			ProductOrder saveOrder = orderRepository.save(order);
			commonUtil.sendMailForProductOrder(saveOrder, "success");

			orderRepository.save(order);


		}
	}

	@Override
	public List<ProductOrder> getOrdersByUser(Integer userId) {
		List<ProductOrder> orders = orderRepository.findByUserId(userId);
		return orders;
	}

	@Override

	public ProductOrder updateOrderStatus(Integer id, String status) {

	public Boolean updateOrderStatus(Integer id, String status) {

		Optional<ProductOrder> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			ProductOrder productOrder = findById.get();
			productOrder.setStatus(status);

			ProductOrder updateOrder = orderRepository.save(productOrder);
			return updateOrder;
		}
		return null;
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Page<ProductOrder> getAllOrdersPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return orderRepository.findAll(pageable);

	}

	@Override
	public ProductOrder getOrdersByOrderId(String orderId) {
		return orderRepository.findByOrderId(orderId);
	}

}
<<<<<<< HEAD
=======

			orderRepository.save(productOrder);
			return true;
		}
		return false;
	}

}

>>>>>>> afec4ef84d587ed9fe9fbc1e8194792410eb0df2
