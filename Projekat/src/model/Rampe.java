package model;

import java.util.ArrayList;

public class Rampe {

	ArrayList<Rampa> rampe;
	
	private static Rampe instanca_Rampe = null;
	
	
	public Rampe() {
		super();
		this.rampe = new ArrayList<Rampa>();
	}


	public static Rampe getInstance()
	{
		if (instanca_Rampe == null)
			instanca_Rampe = new Rampe();
		
		return instanca_Rampe;
	}


	public ArrayList<Rampa> getRampe() {
		return rampe;
	}


	public void setRampe(ArrayList<Rampa> rampe) {
		this.rampe = rampe;
	}
}
