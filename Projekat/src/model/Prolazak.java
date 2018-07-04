package model;

import java.util.Date;

public class Prolazak {
	
	private Date vreme;
	private double iznos;
	private TipVozila tipVozila;
	
	public Prolazak()
	{
		
	}

	public Prolazak(Date vreme, double iznos, TipVozila tipVozila) {
		super();
		this.vreme = vreme;
		this.iznos = iznos;
		this.tipVozila = tipVozila;
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
	
	
}
