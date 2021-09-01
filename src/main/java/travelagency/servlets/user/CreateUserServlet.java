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

@WebServlet(urlPatterns = "/createuser", name = "CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserData userData = new UserData();
		userData.setName(request.getParameter("name"));
		userData.setLastName(request.getParameter("lastname"));
		userData.setDayOfBirthd(Date.valueOf(request.getParameter("birthday")));
		userData.setEmail(request.getParameter("email"));
		userData.setIdRole(Integer.parseInt(request.getParameter("role")));
		
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");

		if (password.equals(passwordCheck)) {
			userData.setPassword(passwordCheck);
			userDao.setUser(userData);
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} 
		
//		else {
//			response.sendRedirect(getServletContext().getContextPath() + "/error");
//		}
	}

}
