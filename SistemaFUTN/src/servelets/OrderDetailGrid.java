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

/**
 * Servlet implementation class OrderDetailGrid
 */
@WebServlet("/OrderDetailGrid")
public class OrderDetailGrid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailGrid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CtrlOrders ctrlOrders = new CtrlOrders();
		
		Order order = new Order();
		
		int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
		
		ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("orders");
		
		order = ctrlOrders.getOrder(orders,orderNumber);
		
		request.getSession().setAttribute("orderToShow",order);
		
		request.getRequestDispatcher("OrderDetailsGrid.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
