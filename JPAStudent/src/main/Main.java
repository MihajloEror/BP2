package main;

import java.util.List;

import crud.StudentCrud;
import model.Student;

public class Main {
		
		public static void main(String[] args){
		
			Student s = new Student();
			s.setIme("Pera");
			s.setPrezime("Peric");
			StudentCrud sc = new StudentCrud();
			sc.insertStudent(s);
			
			sc.updateStudent(s, "Petar");
			
			List<Student> studenti = sc.listStudent();
			for(Student s1 : studenti){
				System.out.println(s1);
			}
			
			sc.deleteStudent(s);
			
			studenti = sc.listStudent();
			for(Student s1 : studenti){
				System.out.println(s1);
			}
		}

	}


	
