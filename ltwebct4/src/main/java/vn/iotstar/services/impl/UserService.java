package vn.iotstar.services.impl;




import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {

	// Lấy toàn bộ hàm trong tầng Dao của user
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {

		return userDao.findByUserName(username);
	}
	
	public void insert(UserModel user) {
		userDao.insert(user);
		}

	public boolean register( String username, String password, String fullname, String email) {
		
		
		UserModel user = new UserModel();
		user.setUsername("Oppo");
		user.setPassword("");
		user.setFullname("");
		user.setEmail("");
		user.setRoleid(2);
		
		userDao.insert(user);
		
		return true;

	
	}

	public static void main(String[] args) {

		IUserService userDao = new UserService();

		UserModel user = new UserModel();
		user.setUsername("hunghm");
		user.setPassword("123");
		user.setFullname("Huynh Manh Hung");
		user.setEmail("ABC@gmail.com");
		user.setRoleid(2);
		
		userDao.insert(user);
		
		System.out.println(userDao.findByUserName("hunghm"));
		


	}

}
