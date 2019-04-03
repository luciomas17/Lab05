package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Parola {

	List<Character> parola;
	
	public Parola() {
		parola = new ArrayList<Character>();
	}

	public Parola(String s) {
		parola = new ArrayList<Character>();
		s = s.toLowerCase();
		
		for(int i=0; i<s.length(); i++)
			parola.add(s.charAt(i));
	}
	
	public Parola(Parola other) {
		this.parola = new ArrayList<Character>(other.parola);
	}

	public int getSize() {
		return parola.size();
	}
	
	public List<Character> getList() {
		return parola;
	}

	@Override
	public String toString() {
		String s = "";
		
		for(Character c : parola)
			s += c;
		
		return s;
	}

	public boolean isCorrect() {
		AnagrammaDAO dao = new AnagrammaDAO();
		
		return dao.isCorrect(this.toString());
	}

	public void add(Character c) {
		parola.add(c);
	}

	public void removeLast() {
		parola.remove(parola.size()-1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

}
