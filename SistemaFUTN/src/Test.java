import entidades.Student;
import data.UserData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Student s=new Student();
	Student t=new Student();
		UserData uD=new UserData();
		
		s.setLegajo("11");
		s.setAdress("corrientes");
		s.setFirstName("lisandro");
		s.setCredit(10);
		s.setLastName("juan");
		s.setMail("asasa");
		s.setPhone1("4816995");

		uD.add(s);
		
		t=uD.getByLegajo(s);
		System.out.println(s.getLegajo());
	}

}
