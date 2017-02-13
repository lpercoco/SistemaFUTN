package negocio;

import java.util.ArrayList;

import data.TeachingMaterialData;
import entidades.TeachingMaterial;

public class CtrlTeachingMaterial {
	private TeachingMaterialData data;
	
	//faltan excepciones
	
	public CtrlTeachingMaterial(){
		data=new TeachingMaterialData();
	}

	public void add(TeachingMaterial tm){
		data.add(tm);
	}
	
	public ArrayList<TeachingMaterial> getTeachingMaterials(TeachingMaterial tmSearch){
		return data.getTeachingMaterials(tmSearch);
	}

	public TeachingMaterial getTeachingMaterial(TeachingMaterial tm) {
		return data.getTeachingMaterial(tm);
	}
}
