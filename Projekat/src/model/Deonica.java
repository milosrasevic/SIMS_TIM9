package model;

import java.util.ArrayList;

public class Deonica {
	private NaplatnaStanica ulaznaStanica;
	private NaplatnaStanica izlaznaStanica;
	private ArrayList<Cenovnik> cenovnici = new ArrayList<Cenovnik>();
	
	public Deonica()
	{
		
	}

	public Deonica(NaplatnaStanica ulaznaStanica, NaplatnaStanica izlaznaStanica) {
		super();
		this.ulaznaStanica = ulaznaStanica;
		this.izlaznaStanica = izlaznaStanica;
	}

	public Deonica(NaplatnaStanica ulaznaStanica, NaplatnaStanica izlaznaStanica, ArrayList<Cenovnik> cenovnici) {
		super();
		this.ulaznaStanica = ulaznaStanica;
		this.izlaznaStanica = izlaznaStanica;
		this.cenovnici = cenovnici;
	}

	public NaplatnaStanica getUlaznaStanica() {
		return ulaznaStanica;
	}

	public void setUlaznaStanica(NaplatnaStanica ulaznaStanica) {
		this.ulaznaStanica = ulaznaStanica;
	}

	public NaplatnaStanica getIzlaznaStanica() {
		return izlaznaStanica;
	}

	public void setIzlaznaStanica(NaplatnaStanica izlaznaStanica) {
		this.izlaznaStanica = izlaznaStanica;
	}

	public ArrayList<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(ArrayList<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}
	
	
}
