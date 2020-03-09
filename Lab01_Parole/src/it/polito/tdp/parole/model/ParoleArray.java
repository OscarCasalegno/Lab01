package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.List;

public class ParoleArray {
	
	private List<String> parole;
		
	public ParoleArray() {
		parole=new ArrayList<String>();
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

	public void delParola(String selezionato) {
		// TODO Auto-generated method stub
		parole.remove(selezionato);
	}

}
