package travelagency.servlets.tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.TourDao;
import travelagency.dao.impl.DefaultTourDao;
import travelagency.models.TourData;
import travelagency.models.UserData;


@WebServlet(urlPatterns="/tourById", name="ShowTourByIdServlet")
public class ShowTourByIdServlet extends HttpServlet {

	private TourDao tourDao;

	{
		tourDao = DefaultTourDao.getInstance();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TourData tour = tourDao.getTourById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("tour", tour);
		request.getRequestDispatcher("WEB-INF/views/showTour.jsp").forward(request, response);
	}

}
