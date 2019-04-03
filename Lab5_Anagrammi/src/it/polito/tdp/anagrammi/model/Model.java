package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class Model {
	
	Set<Parola> soluzione;
	
	public Set<Parola> trovaAnagrammi(Parola daAnagrammare){
		soluzione = new HashSet<Parola>();
		
		Parola parziale = new Parola();
		recursive(parziale, 0, daAnagrammare);
		
		return soluzione;
	}

	private void recursive(Parola parziale, int l, Parola daAnagrammare) {
		
		// System.out.println(parziale.toString());
		
		if(l == daAnagrammare.getSize()) {
			if(parziale.isCorrect()) {
				soluzione.add(new Parola(parziale));
			}
			return;
		}
		
		for(int i=0; i<daAnagrammare.getSize(); i++) {
			if(charCounter(parziale, daAnagrammare.getList().get(i)) < charCounter(daAnagrammare, daAnagrammare.getList().get(i))) {
				parziale.add(daAnagrammare.getList().get(i));
				recursive(parziale, l+1, daAnagrammare);
				parziale.removeLast();
			}	
		}
	}
	
	private int charCounter(Parola p, char character) {
		int count = 0;
		
		for(Character c : p.getList()) {
			if(c.equals(character))
				count++;
		}
		
		return count;
	}
}
