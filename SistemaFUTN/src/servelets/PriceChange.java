package servelets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import futn.CopyPrice;
import negocio.CtrlFutn;
import utils.ApplicationException;

/**
 * Servlet implementation class PriceChange
 */
@WebServlet("/PriceChange")
public class PriceChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceChange() {
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
		CtrlFutn ctrl=new CtrlFutn();
	    CopyPrice newCopyPrice=new CopyPrice();
	    CopyPrice actualCopyPrice=new CopyPrice();
    	Calendar cal = Calendar.getInstance();
	    Date dBegin;
	    Date dEnd;

	    //faltan validaciones
	    
	    actualCopyPrice=ctrl.getActualCopyPrice();
	    
	    //trae fecha ingresada
	    dBegin=java.sql.Date.valueOf(request.getParameter("date"));
	    
	    //crea nuevo precio y lo agrega
	    newCopyPrice.setBeginDate(dBegin);
	    newCopyPrice.setDuplexPrice(Double.parseDouble(request.getParameter("duplex")));
	    newCopyPrice.setSimplePrice(Double.parseDouble(request.getParameter("simple")));
	    
	    try {
			ctrl.add(newCopyPrice);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //resta 1 dia a la fecha ingresada, la setea como fecha fin en el precio actual y lo actualiza en la db
	    cal.setTime(dBegin);
	    cal.add(Calendar.DAY_OF_MONTH,-1);
	    dEnd=new Date(cal.getTime().getTime());
	    actualCopyPrice.setEndDate(dEnd);
	    
	    try {
			ctrl.update(actualCopyPrice);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	    request.getRequestDispatcher("PriceChange.jsp").forward(request, response);

		doGet(request, response);
	}

}
