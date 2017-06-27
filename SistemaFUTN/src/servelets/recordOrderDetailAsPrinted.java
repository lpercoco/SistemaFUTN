package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import negocio.CtrlOrders;
import utils.ApplicationException;

/**
 * Servlet implementation class recordOrderDetailAsPrinted
 */
@WebServlet("/recordOrderDetailAsPrinted")
public class recordOrderDetailAsPrinted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public recordOrderDetailAsPrinted() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CtrlOrders ctrlOrders = new CtrlOrders();
		ArrayList<Order> orders = new ArrayList<Order>();
		int  numberOfOrdersToPrint;
		
		int orderDetailNumber= Integer.parseInt(request.getParameter("orderDetailNumber"));
		Order order = (Order)request.getSession().getAttribute("orderToShow");

		order=ctrlOrders.recordOrderDetailAsPrinted(order,orderDetailNumber);

		orders=ctrlOrders.getUnreadyAndUndeliveryOrders();

		numberOfOrdersToPrint=ctrlOrders.getNumberOfOrdersToPrint(orders);
		
		request.getSession().setAttribute("orderToShow",order);
		request.getSession().setAttribute("orders",orders);
		request.getSession().setAttribute("numberOfOrdersToPrint",numberOfOrdersToPrint);

		if(numberOfOrdersToPrint==0){
			request.getSession().setAttribute("exceptionMessage","There are no orders to print");	
		}

		if(order.isOrderState()){
			request.getRequestDispatcher("OrdersGrid.jsp").forward(request, response); 
			//mostrar mensaje?
		}else{
			request.getRequestDispatcher("OrderDetailsGrid.jsp").forward(request, response); 

		}

	}
}


