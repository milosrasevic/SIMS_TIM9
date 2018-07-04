package model;

public class Deonica {
	private NaplatnaStanica ulaznaStanica;
	private NaplatnaStanica izlaznaStanica;
	
	public Deonica()
	{
		
	}

	public Deonica(NaplatnaStanica ulaznaStanica, NaplatnaStanica izlaznaStanica) {
		super();
		this.ulaznaStanica = ulaznaStanica;
		this.izlaznaStanica = izlaznaStanica;
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
	
	
}
