package negocio;

import data.UserData;
import entidades.Order;
import entidades.User;
import utils.ApplicationException;

public class CtrlUsers {
	
	private UserData userData;
	
	public CtrlUsers(){
		
		userData=new UserData();
	
	}
	

	public void addNewStudent(User u) throws ApplicationException{
		
		userData.add(u);
	
	}
	
	
	public User getByLegajo(int legajo) throws ApplicationException{	
		
		return userData.getByLegajo(legajo);	
	
	}

	private boolean areEqual(User uLogin,User uSearch){
		
		if( (uLogin.getLegajo()==uSearch.getLegajo()) && (uLogin.getPassword().equals(uSearch.getPassword()))){
			return true;
		}else{
		   return false;
		}
	}

	
	public User validateLogin(User uLogin) throws ApplicationException {
		
		User uSearch;
		
		uSearch=userData.getByLegajo(uLogin.getLegajo());

		if(areEqual(uLogin,uSearch)){
			return uSearch;
		}else{
			throw new ApplicationException("Password incorrect, try again");
		}

	}

	public void makePayment(Order order) {
		
		userData.update(order.getStudentOrder());
	
	}

	public void addCredit(int legajo, Double creditToAdd) throws ApplicationException {
		
		User s=getByLegajo(legajo);
		
		s.addCredit(creditToAdd);
		
		userData.update(s);
		
	}

	public User update(User userLogged, User userNewValues) {
		
		 userLogged=userLogged.changePersonalData(userNewValues);
		
		 userData.update(userLogged);
		 
		 return userLogged;
	}


	 
}
