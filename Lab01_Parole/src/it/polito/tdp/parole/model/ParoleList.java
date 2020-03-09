package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;

public class ParoleList {
	
	private List<String> parole;
		
	public ParoleList() {
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

	public void delParola(String selezionato) {
		// TODO Auto-generated method stub
		parole.remove(selezionato);
	}

}
