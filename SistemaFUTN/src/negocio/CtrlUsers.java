package negocio;

import data.UserData;
import entidades.Student;
import utils.ApplicationException;

public class CtrlUsers {
	
	private UserData userData;
	private Student st;
	
	public CtrlUsers(){
		userData=new UserData();
	}
	
	//faltan manejo de excepciones
	
	public void add(Student s) throws ApplicationException{
		st=userData.getByLegajo(s);
		if(st!=null){
			userData.add(s);
		}else{
			throw new ApplicationException("There is already a user with that Legajo");
		}
	}
	
	public void delete(Student s) throws ApplicationException{
		st=userData.getByLegajo(s);
		if(st!=null){
			userData.delete(s);
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
	}
	
	public Student getByLegajo(Student s) throws ApplicationException{
		st=userData.getByLegajo(s);
		if(st!=null){
			return st;
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
		
	}
	
	public void update(Student s) throws ApplicationException{
		st=userData.getByLegajo(st);
		if(st!=null){
			userData.update(s);
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
	}

}
