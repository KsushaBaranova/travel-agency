package travelagency.servlets.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.OrderDao;
import travelagency.dao.impl.DefaultOrderDao;
import travelagency.models.OrderData;


@WebServlet(urlPatterns="/createorder", name="CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderDao orderDao;

	{
		orderDao = DefaultOrderDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/addOrder.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderData orderData=new OrderData();
		orderData.setIdUser(Integer.parseInt(request.getParameter("userId")));
		orderData.setIdTour(Integer.parseInt(request.getParameter("tourId")));
		orderData.setPaid(Boolean.parseBoolean(request.getParameter("isPaid")));
		orderDao.setOrder(orderData);
		response.sendRedirect(getServletContext().getContextPath() + "/allorders");
	}

}
