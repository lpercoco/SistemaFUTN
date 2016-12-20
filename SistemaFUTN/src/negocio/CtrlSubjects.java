package negocio;

import java.util.ArrayList;

import data.SubjectData;
import entidades.Subject;

public class CtrlSubjects {
	private SubjectData data;
	
	public CtrlSubjects(){
		data= new SubjectData();
	}
	
	public ArrayList<Subject> getSubjects(){
		return(data.getSubjects());
	}

}
