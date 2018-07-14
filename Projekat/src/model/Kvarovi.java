package model;

import java.util.ArrayList;

public class Kvarovi {

	ArrayList<Kvar> kvarovi;
	
	private static Kvarovi instanca_Kvarova = null;
	
	
	public Kvarovi() {
		super();
		this.kvarovi = new ArrayList<Kvar>();
	}


	public static Kvarovi getInstance()
	{
		if (instanca_Kvarova == null)
			instanca_Kvarova = new Kvarovi();
		
		return instanca_Kvarova;
	}


	public ArrayList<Kvar> getKvarovi() {
		return kvarovi;
	}


	public void setKvarovi(ArrayList<Kvar> kvarovi) {
		this.kvarovi = kvarovi;
	}
}
