package model;

public class CenovnikVozilo {

	private double cena;
	private Valuta valuta;
	private TipVozila tipVozila;
	private Deonica deonica;
	
	public CenovnikVozilo()
	{
		
	}

	public CenovnikVozilo(double cena, Valuta valuta, TipVozila tipVozila) {
		super();
		this.cena = cena;
		this.valuta = valuta;
		this.tipVozila = tipVozila;
	}

	public CenovnikVozilo(double cena, Valuta valuta, TipVozila tipVozila, Deonica deonica) {
		super();
		this.cena = cena;
		this.valuta = valuta;
		this.tipVozila = tipVozila;
		this.deonica = deonica;
	}

	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public Valuta getValuta() {
		return valuta;
	}


	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}


	public TipVozila getTipVozila() {
		return tipVozila;
	}


	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

	public Deonica getDeonica() {
		return deonica;
	}

	public void setDeonica(Deonica deonica) {
		this.deonica = deonica;
	}
	
	
}
