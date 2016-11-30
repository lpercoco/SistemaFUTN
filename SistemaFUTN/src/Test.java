import entidades.Student;
import futn.CopyPrice;
import negocio.CtrlFutn;
import negocio.CtrlUsers;
import data.UserData;

public class Test {

	public static void main(String[] args) {
		CtrlFutn ctrl=new CtrlFutn();

	    CopyPrice actualCopyPrice=new CopyPrice();
	    
	    actualCopyPrice=ctrl.getActualCopyPrice();
	    if(actualCopyPrice!= null)System.out.println(actualCopyPrice.getBeginDate());
	    if(actualCopyPrice== null)System.out.println("vacio");
		
	}

}
