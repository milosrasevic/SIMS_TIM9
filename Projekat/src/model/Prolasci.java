package model;

import java.util.ArrayList;

public class Prolasci {
	
	ArrayList<Prolazak> prolasci;
	
	
	private static Prolasci instanca_Prolazaka = null;
	
	
	public Prolasci() {
		super();
		this.prolasci = new ArrayList<Prolazak>();
	}


	public static Prolasci getInstance()
	{
		if (instanca_Prolazaka == null)
			instanca_Prolazaka = new Prolasci();
		
		return instanca_Prolazaka;
	}


	public ArrayList<Prolazak> getProlasci() {
		return prolasci;
	}


	public void setProlasci(ArrayList<Prolazak> prolasci) {
		this.prolasci = prolasci;
	}
}
