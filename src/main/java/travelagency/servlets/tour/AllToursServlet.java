package travelagency.servlets.tour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.TourDao;
import travelagency.dao.impl.DefaultTourDao;
import travelagency.models.TourData;
import travelagency.models.UserData;


@WebServlet(urlPatterns="/alltours", name="AllToursServlet")
public class AllToursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TourDao tourDao;

	{
		tourDao = DefaultTourDao.getInstance();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		UserData loggedInUser = (UserData) request.getAttribute("loggedInUser");
		request.setAttribute("loggedInUser", loggedInUser);
		request.getRequestDispatcher("WEB-INF/views/allTours.jsp").forward(request, response);
	}

}
