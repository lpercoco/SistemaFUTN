import entidades.Student;
import entidades.Subject;
import futn.CopyPrice;
import negocio.CtrlFutn;
import negocio.CtrlSubjects;
import negocio.CtrlUsers;

import java.util.ArrayList;
import java.util.Iterator;

import data.UserData;

public class Test {

	public static void main(String[] args) {
		CtrlSubjects ctrl=new CtrlSubjects();
		ArrayList<Subject> subjects;
		String prueba[] = null;
		
    	subjects=ctrl.getSubjects();
		
		if(!ctrl.getSubjects().isEmpty()) System.out.println("vacio");
    	
//    	for (int i = 0; i < subjects.size(); i++) {
//			prueba[i]=subjects.get(i).getName();
//		}
		
//    	for(int i=0; i<subjects.size();i++){
//        System.out.println("size="+subjects.size());
//        System.out.println(i);
//		System.out.println(subjects.get(i).getName());
//    	}		
	}

}
