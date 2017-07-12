package negocio;

import java.util.ArrayList;

import data.TeachingMaterialData;
import entidades.Subject;
import entidades.TeachingMaterial;
import utils.ApplicationException;

public class CtrlTeachingMaterial {
	private TeachingMaterialData data;
		
	public CtrlTeachingMaterial(){
		data=new TeachingMaterialData();
	}

	public void add(TeachingMaterial tm){		
		data.add(tm);
	}
	
	public ArrayList<TeachingMaterial> getTeachingMaterials(TeachingMaterial tmSearch) throws ApplicationException{		
		//return tm's by subject or (subject and similar title)
		return data.getTeachingMaterials(tmSearch);
	}

	public TeachingMaterial getTeachingMaterial(TeachingMaterial tm) {		
		//return tm by tm code
		return data.getTeachingMaterial(tm);
	}

}
