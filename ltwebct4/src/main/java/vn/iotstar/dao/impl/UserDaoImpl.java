package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;


public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {

		String sql = "select * from users";

		List<UserModel> list = new ArrayList<>(); // Tạo 1 list để truyền dữ liệu

		try {
			conn = super.getConnection(); // kết nối database
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next() /* Next từng DÒNG tới cuối bảng */) {

				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("images"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"),
						rs.getInt("roleid"), rs.getDate("createDate"))); // Add vào

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById (String id) {

		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO users ( username, password, fullname, email, roleid) VALUES ( ?, ?, ?, ?, ?)";

		try {
			conn = super.getConnection(); // kết nối database

			ps = conn.prepareStatement(sql);// ném câu sql vào cho thực thi

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());	
			ps.setInt(5, user.getRoleid());
			

			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Test chương trình
	public static void main(String[] args) {

		 UserDaoImpl userDao = new UserDaoImpl();

		 //userDao.insert(new UserModel (3,"abcd", "abcd@gmail.com","1234","","abcdef"));
	 
/*
		try {
			//IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUserName("trungnh"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		/*
        IUserDao userDao = new UserDaoImpl();
        
        Date date = new Date(1L);
		
		userDao.insert(new UserModel ("","hunghm", "123","" ,"HuynhManhHung","","abc@gmali.com",2,date)); 
        
        System.out.println(userDao.findByUserName("hunghm"));*/

		UserModel usermodel = new UserModel();
		usermodel.setUsername("hunghm");
		usermodel.setPassword("123");
		usermodel.setFullname("Huynh Manh Hung");
		usermodel.setEmail("ABC@gmail.com");
		usermodel.setRoleid(2);
		
		userDao.insert(usermodel);
		
		List<UserModel> list = userDao.findAll();
		 
		for (UserModel user : list) { System.out.println(user); }
		
		//System.out.println(userDao.findByUserName("hunghm"));

	}
}
