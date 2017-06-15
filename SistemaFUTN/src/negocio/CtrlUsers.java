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
	
	//faltan casos especiales?
	
	//actualmente no se pueden agregar admin
	//sentencia sql crea estudiantes por defecto
	public void add(User u) throws ApplicationException{
		userData.add(u);
	}
	
	//se puede borrar un admin?
	//si es solo un usuario admin, NO
	public void delete(User u) throws ApplicationException{
		User user;
		user=userData.getByLegajo(u);
		if(user!=null){
			userData.delete(u);
		}else{
			throw new ApplicationException("There isnt a user with that Legajo");
		}
	}
	
	public User getByLegajo(User u) throws ApplicationException{
		
		return userData.getByLegajo(u);
		
	}
	
	//se pueden modificar los datos de admin?
	// si se puede,considerando que los admin no hacer ordenes, no mostrar para modificar el credito
	//en el html?
	public void update(User u) throws ApplicationException{
			userData.update(u);
	}
	
	public boolean areEqual(User uLogin,User uSearch){
		if((uLogin.getLegajo().equals(uSearch.getLegajo())) && (uLogin.getPassword().equals(uSearch.getPassword()))){
			return true;
		}else{
		   return false;
		}
	}

	
	public User validateLogin(User uLogin) throws ApplicationException {
		User uSearch;
		uSearch=userData.getByLegajo(uLogin);

		if(areEqual(uLogin,uSearch)){
			return uSearch;
		}else{
			throw new ApplicationException("Password incorrect, try again");
		}

	}

	public void makePayment(Order order) {
		
		userData.update(order.getStudentOrder());
	
	}

	public void addCredit(User s, Double creditToAdd) throws ApplicationException {
		
		s.addCredit(creditToAdd);
		
		userData.update(s);
		
	}
	 
}
