package vn.iotstar.services;


import vn.iotstar.models.UserModel;

public interface IUserService {
	
	UserModel login(String username, String password);
	
	UserModel findByUserName(String username);
	
	boolean register( String username, String password, String fullname, String email); 	

	void insert(UserModel user);
}
