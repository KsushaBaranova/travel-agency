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


@WebServlet(urlPatterns="/updateorder", name="UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderDao orderDao;

	{
		orderDao = DefaultOrderDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("order", orderDao.getOrderById(
				Integer.parseInt(request.getParameter("orderId"))));
		request.getRequestDispatcher("WEB-INF/views/updateOrder.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		OrderData orderData=new OrderData();
		orderData.setIdOrder(Integer.parseInt(request.getParameter("orderId")));
		orderData.setIdUser(Integer.parseInt(request.getParameter("userId")));
		orderData.setIdTour(Integer.parseInt(request.getParameter("tourId")));
		orderData.setPaid(Boolean.parseBoolean(request.getParameter("isPaid")));
		orderDao.updateOrder(orderData);
		response.sendRedirect(getServletContext().getContextPath() + "/allorders");
	}

}
