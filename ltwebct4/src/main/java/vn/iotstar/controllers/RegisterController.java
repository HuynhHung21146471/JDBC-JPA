package vn.iotstar.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
			
		String username = req.getParameter("username");
		String password = req.getParameter("psw");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		
		
		boolean  isSuccess = service.register(username, password, fullname, email);
		if (isSuccess ) {				
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		}
		}


}
