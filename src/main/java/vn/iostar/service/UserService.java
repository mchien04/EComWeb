package vn.iostar.service;

import java.util.List;

import vn.iostar.model.UserDtls;

public interface UserService {
	
	public UserDtls saveUser(UserDtls user);
	
	public UserDtls getUserByEmail(String email);
	
	public List<UserDtls> getUsers(String role);
	
	public Boolean updateAccountStatus(Integer id, Boolean status);

}
