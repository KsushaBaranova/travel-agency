package travelagency.servlets;

import static travelagency.filters.MyAccountFilter.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.UserData;
import static travelagency.filters.AdminFilter.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} else {
			UserData user = userDao.getUserPasswordByEmail(login);
			if (user != null && user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute(LOGGED_IN_USER_KEY, user);
				if (user.getIdRole() == 1) {
					session.setAttribute(ADMIN_KEY, user);
				}
				response.sendRedirect(getServletContext().getContextPath() + "/homePage");
			} else {
				response.sendRedirect(getServletContext().getContextPath() + "/login");
			}
		}
	}

}
