package negocio;

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
}
