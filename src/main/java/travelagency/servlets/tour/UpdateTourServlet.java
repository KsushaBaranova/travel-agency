package travelagency.servlets.tour;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.TourDao;
import travelagency.dao.impl.DefaultTourDao;
import travelagency.models.TourData;
import travelagency.models.UserData;


@WebServlet(urlPatterns="/updatetour", name="UpdateTourServlet")
public class UpdateTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TourDao tourDao;

	{
		tourDao = DefaultTourDao.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("tour", tourDao.getTourById(
				Integer.parseInt(request.getParameter("tourId"))));
		request.getRequestDispatcher("WEB-INF/views/updateTour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		TourData tourData=new TourData();
		tourData.setIdTour(Integer.parseInt(request.getParameter("tourId")));
		tourData.setNameTour(request.getParameter("nameTour"));
		tourData.setDescriptionTour(request.getParameter("descriptionTour"));
		tourData.setDateTour(Date.valueOf(request.getParameter("dateTour")));
		tourData.setPrice(Integer.parseInt(request.getParameter("price")));
		tourData.setCity(Integer.parseInt(request.getParameter("idCity")));
		tourData.setHotel(Integer.parseInt(request.getParameter("idHotel")));
		
		tourDao.updateTour(tourData);
		
		response.sendRedirect(getServletContext().getContextPath() + "/alltours");
	}

}
