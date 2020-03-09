package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		parole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		parole.sort(null);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

}
