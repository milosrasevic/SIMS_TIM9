package model;

import java.util.ArrayList;
import java.util.Date;

public class Cenovnik {

	private Date datumStupanja;
	private ArrayList<CenovnikVozilo> cenovniciVozila = new ArrayList<CenovnikVozilo>();
	
	public Cenovnik()
	{
		
	}

	public Cenovnik(Date datumStupanja) {
		super();
		this.datumStupanja = datumStupanja;
	}
	

	public Cenovnik(Date datumStupanja, ArrayList<CenovnikVozilo> cenovniciVozila) {
		super();
		this.datumStupanja = datumStupanja;
		this.cenovniciVozila = cenovniciVozila;
	}

	public Date getDatumStupanja() {
		return datumStupanja;
	}

	public void setDatumStupanja(Date datumStupanja) {
		this.datumStupanja = datumStupanja;
	}

	public ArrayList<CenovnikVozilo> getCenovniciVozila() {
		return cenovniciVozila;
	}

	public void setCenovniciVozila(ArrayList<CenovnikVozilo> cenovniciVozila) {
		this.cenovniciVozila = cenovniciVozila;
	}
	
	
}
