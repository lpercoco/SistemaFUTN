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
import entidades.Student;
import negocio.CtrlOrders;


/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	String[] tmCodes;
	String[] prueba;
	
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
		Order o=new Order();
		CtrlOrders ctrl=new CtrlOrders();
		
		//o.setStudentOrder((Student)request.getSession().getAttribute("studentOnline")); 
		o.setDetails((ArrayList<OrderDetail>) request.getSession().getAttribute("orderDetails"));
		o.setTotalAmount();
		
		//eliminar datos de la session
		request.getSession().setAttribute("orderDetails",null);

		//registrar orden en la base de datos
		ctrl.addOrder(o);
		
		request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response); // orden registrada pantalla
	}

}
