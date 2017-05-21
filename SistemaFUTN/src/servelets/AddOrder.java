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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			    
		CtrlOrders ctrl=new CtrlOrders();
		ArrayList<OrderDetail> orderDetails= new ArrayList<OrderDetail>();
		User student;
		
		orderDetails=(ArrayList<OrderDetail>) request.getSession().getAttribute("orderDetails");
		student= (User)request.getSession().getAttribute("userAuthenticated");
		
		//si quiere entrar al jsp de addteachingmaterialtoorder no estando logiado
		//mostrar mensaje y/o login
		
		//validar cada vez que agrega un apunte si le alcanza el credito????
		

		try {
			ctrl.newOrder(orderDetails,student);
		} catch (ApplicationException e) {

			//si no esta logiado, muestra mensaje y login
			//si no tiene items, muestra mensaje 
			
			e.printStackTrace();
		}
		
		//eliminar datos de la session
		request.getSession().setAttribute("orderDetails",null);
		request.getSession().setAttribute("copyPrice", null);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response); // orden registrada pantalla
	}

}
