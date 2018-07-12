package gui;

import javafx.scene.control.TextField;
import model.TipVozila;
import model.Valuta;

public class CenaPolje extends TextField{
	private TipVozila tipVozila;
	private Valuta valuta;
	
	public CenaPolje()
	{
	}

	public CenaPolje(TipVozila tipVozila, Valuta valuta) {
		this.tipVozila = tipVozila;
		this.valuta = valuta;
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
