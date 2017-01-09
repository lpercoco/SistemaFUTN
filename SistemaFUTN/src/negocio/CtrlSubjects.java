package negocio;

import java.util.ArrayList;

import data.SubjectData;
import entidades.Subject;

public class CtrlSubjects {
	private SubjectData data;
	
	public CtrlSubjects(){
		data= new SubjectData();
	}
	
	//faltan excepciones
	
	public ArrayList<Subject> getSubjects(){
		return(data.getSubjects());
	}
	
	public Subject getByName(Subject s){
		return(data.getByName(s));
	}

}
