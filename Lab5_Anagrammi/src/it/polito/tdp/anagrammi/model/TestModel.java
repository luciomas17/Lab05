package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		
		Parola p = new Parola("telefono");
		System.out.println("Parola da anagrammare: " + p.toString());
		
		Model model = new Model();
		Set<Parola> soluzioni = model.trovaAnagrammi(p);
		
		System.out.println("Stampo anagrammi:");
		for(Parola anagramma : soluzioni)
			System.out.println(anagramma.toString());
		
	}
}
