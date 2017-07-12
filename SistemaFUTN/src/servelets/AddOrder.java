package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import entidades.Order;
import entidades.OrderDetail;
import entidades.User;
import negocio.CtrlOrders;
import negocio.CtrlUsers;
import utils.ApplicationException;


/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			    
		CtrlOrders ctrlOrders=new CtrlOrders();
		CtrlUsers ctrlUsers=new CtrlUsers();

		Order order=(Order)request.getSession().getAttribute("order");
		

		ctrlOrders.addOrder(order);
		
		ctrlUsers.makePayment(order);

		
		//get ALL orders
		ArrayList<Order> orders = ctrlOrders.getUndeliveredAndUnprintedOrders(order.getStudentOrder());
		
		//update user credit session
		request.getSession().setAttribute("userAuthenticated", order.getStudentOrder());
		
		//add new order to session
		
		request.getSession().setAttribute("orders", orders);

		//message
		request.getSession().setAttribute("message","Order added successfully");
		
		//Clean session
		request.getSession().setAttribute("order", null);
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("copyPrice", null); 
		
		request.getRequestDispatcher("Home.jsp").forward(request, response); 
	}

}
