package model;

import java.util.Date;

public class Prolazak {
	
	private Date vreme;
	private double iznos;
	private TipVozila tipVozila;
	private Valuta valuta;
	
	public Prolazak()
	{
		
	}

	public Prolazak(Date vreme, double iznos, TipVozila tipVozila, Valuta valuta) {
		super();
		this.vreme = vreme;
		this.iznos = iznos;
		this.tipVozila = tipVozila;
		this.valuta = valuta;
	}

	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	
	
	
	
}
