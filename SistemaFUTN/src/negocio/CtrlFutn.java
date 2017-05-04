package negocio;

import java.sql.Date;

import data.FutnData;
import futn.CopyPrice;
import utils.ApplicationException;

public class CtrlFutn {
	private FutnData fData;
	
	public CtrlFutn(){
		fData=new FutnData();
	}
		
	//lanza excepcion si ya se cambio el precio en el mismo dia
	//para simplificar el sistema y evitar  tener que registrar horarios
	// y realizar validaciones de tiempo tambien
	
	//la segunda validacion es necesaria?	
	public void add(CopyPrice cp) throws ApplicationException{
		CopyPrice cpAux=fData.getActualCopyPrice();
		
		cp.setBeginDate(fData.getCurrentDate());
				
		if(cp.getBeginDate().compareTo(cpAux.getBeginDate())>0){
			fData.add(cp);
		}else if(cp.getBeginDate().compareTo(cpAux.getBeginDate())==0){
			throw new ApplicationException("The price has already been changed today");
		}else if(cp.getBeginDate().compareTo(cpAux.getBeginDate())<0){
			throw new ApplicationException("Check with administrator");
		}
	}

	//que no exista precio actual?
	public CopyPrice getActualCopyPrice(){
		return fData.getActualCopyPrice(); 
	}
	
}
