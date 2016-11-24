import entidades.Student;
import negocio.CtrlUsers;
import data.UserData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s= new Student();
		Student stu=new Student();
		CtrlUsers ctrl=new CtrlUsers();
		
		s.setLegajo("11");
		ctrl.delete(s);
		
	
	}

}
