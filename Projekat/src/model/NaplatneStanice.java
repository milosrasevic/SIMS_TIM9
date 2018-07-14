package model;

import java.util.ArrayList;

public class NaplatneStanice {
	ArrayList<NaplatnaStanica> naplatne_stanice;

	private static NaplatneStanice instanca_Naplatnih_stanica = null;
	
	
	public NaplatneStanice() {
		super();
		this.naplatne_stanice = new ArrayList<NaplatnaStanica>();
	}


	public static NaplatneStanice getInstance()
	{
		if (instanca_Naplatnih_stanica == null)
			instanca_Naplatnih_stanica = new NaplatneStanice();
		
		return instanca_Naplatnih_stanica;
	}
	public ArrayList<NaplatnaStanica> getNaplatne_stanice() {
		return naplatne_stanice;
	}

	public void setNaplatne_stanice(ArrayList<NaplatnaStanica> naplatne_stanice) {
		this.naplatne_stanice = naplatne_stanice;
	}
	
	
}
