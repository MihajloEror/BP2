package main;

import java.util.List;

import crud.NastavnikCrud;
import crud.PredmetCrud;
import model.Nastavnik;
import model.Predmet;

public class GlavniProgram {

	public static void main(String[] args) {
		
		NastavnikCrud nc = new NastavnikCrud();
		PredmetCrud pc = new PredmetCrud();
		
		Nastavnik n = new Nastavnik();
		n.setIme("Ana");
		n.setPrezime("Vasic");
		
		Nastavnik nast = nc.getNastavnik(n);
		System.out.println(nast);
		
		nc.updateNastavnik(nast, "vanredni profesor");
		System.out.println(nast);
		
//		System.out.println("predmeti koje predaje Marko Panic: ");
//		List<Predmet> predmeti = pc.predavaniPredmeti(nast);
//		for(Predmet p : predmeti){
//			System.out.println(p);
//		}
		
//		nc.deleteNastavnik(nast);
//		
//		nc.insertNastavnik(n);
		
//		Nastavnik n = nc.findNastavnik(1);
//		System.out.println(n);
		
//		Predmet p = new Predmet();
//		p.setNaziv("Baze podataka 1");
////		pc.insertPredmet(p);
		
//		Predmet p = pc.findPredmet(3);
//		System.out.println(p);
		
//		Predmet pred = pc.getPredmet(p);
		
//		pc.deletePredmet(pred);
//				
//		nc.poveziNastavnikaIPredmet(nast, pred);
		
//		List<Nastavnik> nastavnici = nc.listNastavnici();
//		for(Nastavnik n : nastavnici){
//			System.out.println(n);
//		}
//		
//		List<Predmet> predmeti = pc.listPredmeti();
//		for(Predmet p : predmeti){
//			System.out.println(p);
//		}
		
//		Predmet p = new Predmet();
//		p.setNaziv("Baze podataka 1");
//		Predmet pred = pc.getPredmet(p);
//		
//		System.out.println("Nastavnici koji predaju Baze podataka 1: ");
//		List<Nastavnik> predavaci = nc.listPredavaci(pred);
//		for(Nastavnik n1 : predavaci){
//			System.out.println(n1);
//		}
		
		
		System.exit(0);
		

	}

}
