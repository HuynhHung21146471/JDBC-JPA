package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	

	List<UserModel> findAll();
	
	UserModel findById(String id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

}
