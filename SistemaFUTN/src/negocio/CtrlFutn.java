package negocio;

import data.FutnData;
import futn.CopyPrice;
import utils.ApplicationException;

public class CtrlFutn {
	private FutnData fData;
	
	public CtrlFutn(){
		fData=new FutnData();
	}
		
	//lanza excepcion si ya se cambio el precio en el mismo dia
	//prueba
	public void add(CopyPrice cp) throws ApplicationException{
		CopyPrice cpAux=fData.getCurrentCopyPrice();
		
		int response;
		
		cp.setBeginDate(fData.getCurrentDate());
		
		response = cp.getBeginDate().compareTo(cpAux.getBeginDate());
				
		if(response>0){
			fData.add(cp);
			return;
		}
		
		if(response==0){
			throw new ApplicationException("You can't change the copies price twice on the same day");
		}
        
		if(response<0){
			throw new ApplicationException("Check with administrator");
		}
	}

	public CopyPrice getCurrentCopyPrice(){
		return fData.getCurrentCopyPrice(); 
	}
	
}
