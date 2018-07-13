package model;

import java.util.ArrayList;

public class Deonice {
	ArrayList<Deonica> deonice;
	
	
	private static Deonice instanca_Deonice = null;
	
	
	public Deonice() {
		super();
		this.deonice = new ArrayList<Deonica>();
	}


	public static Deonice getInstance()
	{
		if (instanca_Deonice == null)
			instanca_Deonice = new Deonice();
		
		return instanca_Deonice;
	}


	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}


	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}


}
