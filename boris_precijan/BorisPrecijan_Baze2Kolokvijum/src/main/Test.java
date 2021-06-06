package main;

import java.util.List;

import crud.Crud;
import model.Autor;

/*
 * Test klasa
 * Boris Precijan
 * 86/18
 */

public class Test {

	public static void main(String[] args) {
		Crud crud = new Crud();
		List<Autor> autori = crud.sviAutori();
		for (Autor a : autori) {
			System.out.println(a);
			a.getKnjige().stream().forEach(System.out::println);
		}
		System.exit(0);
	}

}
