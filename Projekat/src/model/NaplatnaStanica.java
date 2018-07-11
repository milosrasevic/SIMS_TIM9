package model;

import java.util.ArrayList;

public class NaplatnaStanica {
	private String naziv;
	private ArrayList<NaplatnoMesto> naplatnaMesta = new ArrayList<NaplatnoMesto>();
	
	public NaplatnaStanica()
	{
		
	}

	public NaplatnaStanica(String naziv) {
		super();
		this.naziv = naziv;
	}
	
	

	public NaplatnaStanica(String naziv, ArrayList<NaplatnoMesto> naplatnaMesta) {
		super();
		this.naziv = naziv;
		this.naplatnaMesta = naplatnaMesta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public static void pregledajIzvestaje()
	{
		
	}
	public static void promeniCenovnik()
	{
		
	}
	public static void pregledajKvarove()
	{
		
	}
	public static void dodajNaplatnoMesto()
	{
		
	}
	public static void izmeniNaplatnoMesto()
	{
		
	}
	public static void obrisiNaplatnoMesto()
	{
		
	}

	public ArrayList<NaplatnoMesto> getNaplatnaMesta() {
		return naplatnaMesta;
	}

	public void setNaplatnaMesta(ArrayList<NaplatnoMesto> naplatnaMesta) {
		this.naplatnaMesta = naplatnaMesta;
	}
	
	
}
