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
		
	public ArrayList<Subject> getSubjects(){
		return(data.getSubjects());
	}
	
	public Subject getByName(String subjectName) throws ApplicationException{
		return data.getByName(subjectName);
	}

}
