package main;

import java.util.GregorianCalendar;

import crud.PolozioCrud;
import crud.PredmetCrud;
import crud.SlusaCrud;
import crud.StudentCrud;
import model.Apredmet;
import model.Astudent;

public class GlavniProgram {

	public static void main(String[] args) {
		
		StudentCrud sc = new StudentCrud();
		PredmetCrud pc = new PredmetCrud();
		PolozioCrud polc = new PolozioCrud();
		SlusaCrud sluc = new SlusaCrud();
		
		Apredmet p = new Apredmet();
		p.setNaziv("Baze podataka 2");
		pc.insertPredmet(p);
		
		Astudent s = new Astudent();
		s.setIme("Ana");
		s.setPrezime("Petrovic");
		sc.insertStudent(s);
		
		sluc.poveziStudentaIPredmet(s, p);
		
		polc.insertPolozio(s, p, 10, new GregorianCalendar(2020, 06, 12).getTime());
		
//		Astudent s = sc.findStudent(-18);
//		System.out.println(s);
//		
//		sc.deleteStudent(s);
		
		System.exit(0);

	}

}
