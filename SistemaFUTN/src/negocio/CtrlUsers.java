package negocio;

import data.UserData;
import entidades.User;
import utils.ApplicationException;

public class CtrlUsers {
	
	private UserData userData;
	
	public CtrlUsers(){
		userData=new UserData();
	}
	
	//faltan manejo de excepciones
	
	public void add(User u) throws ApplicationException{
		User user;
		user=userData.getByLegajo(u);
		if(user!=null){
			userData.add(u);
		}else{
			throw new ApplicationException("There is already a user with that Legajo");
		}
	}
	
	public void delete(User u) throws ApplicationException{
		User user;
		user=userData.getByLegajo(u);
		if(user!=null){
			userData.delete(u);
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
	}
	
	public User getByLegajo(User u) throws ApplicationException{
		User user;
		user=userData.getByLegajo(u);
		if(user!=null){
			return user;
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
		
	}
	
	public void update(User u) throws ApplicationException{
		if(u!=null){
			userData.update(u);
		}else{
			throw new ApplicationException("There isnt a user with thah Legajo");
		}
	}

}
