package negocio;

import java.util.ArrayList;

import data.SubjectData;
import entidades.Subject;
import utils.ApplicationException;

public class CtrlSubjects {
	private SubjectData data;
	
	public CtrlSubjects(){
		data= new SubjectData();
	}
	
	//faltan excepciones
	
	public ArrayList<Subject> getSubjects(){
		return(data.getSubjects());
	}
	
	public Subject getByName(Subject s) throws ApplicationException{
		return(data.getByName(s));
	}

	public Subject getbyCode(Subject s) {
		return (data.getbyCode(s));
	}

}
