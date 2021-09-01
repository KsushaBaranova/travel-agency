package travelagency.servlets.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.UserData;


@WebServlet(urlPatterns="/allusers", name="AllUsersServlet")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<UserData> users = userDao.getAllUsers();
		request.setAttribute("users", users);
//		UserData loggedInUser =new UserData();
//		loggedInUser.setIdRole(1);
//		request.setAttribute("loggedInUser", loggedInUser);
		request.getRequestDispatcher("WEB-INF/views/allUsers.jsp").forward(request, response);;
		
	}

}
