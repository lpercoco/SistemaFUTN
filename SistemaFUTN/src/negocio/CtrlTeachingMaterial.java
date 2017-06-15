package negocio;

import java.util.ArrayList;

import data.TeachingMaterialData;
import entidades.Subject;
import entidades.TeachingMaterial;

public class CtrlTeachingMaterial {
	private TeachingMaterialData data;
		
	public CtrlTeachingMaterial(){
		data=new TeachingMaterialData();
	}

	public void add(TeachingMaterial tm){
		//excepcion ya existe?
		
		data.add(tm);
	}
	
	public ArrayList<TeachingMaterial> getTeachingMaterials(TeachingMaterial tmSearch){
		//devuelve teachingmaterials con  titulo similar o por materia o =materia y titulo similar
		//falta excepcion no devuelve nada
		
		return data.getTeachingMaterials(tmSearch);
	}

	public TeachingMaterial getTeachingMaterial(TeachingMaterial tm) {
		//excepcion  no existe ?
		
		return data.getTeachingMaterial(tm);
	}

	public ArrayList<TeachingMaterial> getTeachingMaterials(String[] tmCodesArray) {
		//busca cada uno de los tm a traves de su codigo y lo devuelve
		//no haria falta excepcion
		
		ArrayList<TeachingMaterial> teachingMaterials = new ArrayList<>();
		
		for (int i = 0; i < tmCodesArray.length; i++) {
			teachingMaterials.add(data.getTeachingMaterial(new TeachingMaterial(tmCodesArray[i])));
		}
		
		return teachingMaterials;
	}

	public TeachingMaterial setMaterialSubject(TeachingMaterial tm, Subject materialSubject) {
		tm.setMaterialSubject(materialSubject);
		return tm;
	}
}
