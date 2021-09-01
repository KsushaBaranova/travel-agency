package travelagency.servlets.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.UserData;

@WebServlet(urlPatterns="/updateuser", name="UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	
	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("user", userDao.getUserById(
				Integer.parseInt(request.getParameter("userId"))));
		request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserData userData=new UserData();
		userData.setId(Integer.parseInt(request.getParameter("userId")));
		userData.setName(request.getParameter("name"));
		userData.setLastName(request.getParameter("lastname"));
		userData.setDayOfBirthd(Date.valueOf(request.getParameter("birthday")));
		userData.setEmail(request.getParameter("email"));
		
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");

		if (password.equals(passwordCheck)) {
			userData.setPassword(passwordCheck);
			userDao.updateUser(userData);
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/error");
		}
		
		
	}
}
