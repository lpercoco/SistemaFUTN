package negocio;

import data.FutnData;
import futn.CopyPrice;
import utils.ApplicationException;

public class CtrlFutn {
	private FutnData fData;
	
	public CtrlFutn(){
		fData=new FutnData();
	}
		
	//cant change copy price twice a day
	public void changeCopyPrice(CopyPrice cp) throws ApplicationException{
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
