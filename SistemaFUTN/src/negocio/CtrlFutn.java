package negocio;

import data.FutnData;
import futn.CopyPrice;

public class CtrlFutn {
	private FutnData fData;
	
	public CtrlFutn(){
		fData=new FutnData();
	}
	
	public void add(CopyPrice cp){
		fData.add(cp); // faltan validaciones	
	}

	public CopyPrice getActualCopyPrice(){
		return fData.getActualCopyPrice(); //faltan validaciones
	}

	public void update(CopyPrice actualCopyPrice) {
		fData.update(actualCopyPrice);
	}
}
