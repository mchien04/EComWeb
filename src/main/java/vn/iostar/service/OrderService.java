package vn.iostar.service;

import vn.iostar.model.OrderRequest;

public interface OrderService {
	
	public void saveOrder(Integer userid,OrderRequest orderRequest);

}
