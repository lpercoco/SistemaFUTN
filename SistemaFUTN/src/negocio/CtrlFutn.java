package negocio;

import data.FutnData;
import futn.CopyPrice;
import utils.ApplicationException;

public class CtrlFutn {
	private FutnData fData;
	
	public CtrlFutn(){
		fData=new FutnData();
	}
	
	//validar que la fecha de inicio sea mayor que la fecha de inicio del precio actual(que no tiene fecha fin todavia)
	public void add(CopyPrice cp) throws ApplicationException{
		CopyPrice cpAux=fData.getActualCopyPrice();
		
		if(cp.getBeginDate().after(cpAux.getBeginDate())){
			fData.add(cp);
		}
		else{
			throw new ApplicationException("begin date must be after current begin date");	
		}
	}

	//que no exista precio actual?
	public CopyPrice getActualCopyPrice(){
		return fData.getActualCopyPrice(); 
	}

	//validar que la fecha de fin sea mayor que la de inicio
	public void update(CopyPrice cp) throws ApplicationException {
		if(cp.getBeginDate().before(cp.getEndDate())){
			fData.update(cp);
		}else{
			throw new ApplicationException("End date must be after start date");
		}
	}
	
}
