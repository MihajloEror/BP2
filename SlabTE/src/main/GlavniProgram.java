package main;

import java.util.List;

import crud.ProizvodCrud;
import crud.RacunCrud;
import crud.StavkaCrud;
import model.Proizvod;
import model.Racun;

public class GlavniProgram {

	public static void main(String[] args) {
		
		ProizvodCrud pc = new ProizvodCrud();
		RacunCrud rc = new RacunCrud();
		StavkaCrud sc = new StavkaCrud();
		
//		Proizvod p1 = new Proizvod();
//		p1.setNaziv("hleb");
//		p1.setCena(80.00);
//		pc.insertProizvod(p1);
//		
//		Proizvod p2 = new Proizvod();
//		p2.setNaziv("mleko");
//		p2.setCena(120.00);
//		pc.insertProizvod(p2);
//		
//		Racun r1 = new Racun();
//		r1.setKlijent("Ana");
//		r1.setTotal(0);
//		rc.insertRacun(r1);
//		
//		sc.insertStavka(r1, 1, p1, 3);
//		sc.insertStavka(r1, 2, p2, 2);
		
		Racun zaUpdate = rc.findRacun(-31);
		rc.izracunajTotal(zaUpdate);
		
//		Racun zaBrisanje = rc.findRacun(-43);
//		rc.deleteRacun(zaBrisanje);
//		
//		List<Racun> racuni = rc.listRacuni();
//		for(Racun r : racuni){
//			System.out.println(r);
//		}
		
		System.exit(0);

	}

}
