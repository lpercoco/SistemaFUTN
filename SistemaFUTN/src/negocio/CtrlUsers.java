package negocio;

import data.UserData;
import entidades.Student;

public class CtrlUsers {
	
	private UserData userData;
	
	public CtrlUsers(){
		userData=new UserData();
	}
	
	public void add(Student s){
		userData.add(s);
	}
	
	public void delete(Student s){
		userData.delete(s);
	}
	
	public Student getByLegajo(Student s){
		Student stu=userData.getByLegajo(s);
		return stu;
	}
	
	public void update(Student s){
		userData.update(s);
	}

}
