package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import entidades.User;
import negocio.CtrlOrders;
import negocio.CtrlUsers;
import utils.ApplicationException;

/**
 * Servlet implementation class SearchOrdersToDelivery
 */
@WebServlet("/SearchOrdersToDelivery")
public class SearchOrdersToDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchOrdersToDelivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);	
		request.getSession().setAttribute("ordersToDeliver",null);
		
		CtrlUsers ctrlUsers=new CtrlUsers();
		CtrlOrders ctrlOrders=new CtrlOrders();

		ArrayList<Order> orders;
		User student=new User();

		student.setLegajo(request.getParameter("legajo"));

		try {
			student=ctrlUsers.getByLegajo(student);

			orders = ctrlOrders.getOrdersToDeliver(student);
			

			request.getSession().setAttribute("ordersToDeliver",orders);

		} catch (ApplicationException e) {

			request.getSession().setAttribute("exceptionMessage",e.getMessage());	

		}finally {
			request.getRequestDispatcher("RetireOrder.jsp").forward(request, response); 
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
