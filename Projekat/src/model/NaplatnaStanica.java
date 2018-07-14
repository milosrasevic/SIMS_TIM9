package model;

import java.util.Date;
import java.util.ArrayList;

public class NaplatnaStanica {
	private String naziv;
	private ArrayList<NaplatnoMesto> naplatnaMesta = new ArrayList<>();
	private ArrayList<Korisnik> zaposleniUStanici = new ArrayList<>();
	
	public NaplatnaStanica()
	{
		
	}

	public NaplatnaStanica(String naziv) {
		super();
		this.naziv = naziv;
	}
	
	//TODO : proveri nacin na koji se odredjuju zaposleni u stanici, i da li treba da postoje u konstruktoru
	public NaplatnaStanica(String naziv, ArrayList<NaplatnoMesto> naplatnaMesta, ArrayList<Korisnik> zaposleni) {
		super();
		this.naziv = naziv;
		this.naplatnaMesta = naplatnaMesta;
		this.zaposleniUStanici = zaposleni;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	public double pregledajIzvestaje(int x,Date datum)
	{
		double suma = 0;
		if(x == 1){
			for(NaplatnoMesto nm : naplatnaMesta){
				for(Prolazak p : nm.getProlasci()){
					suma += p.getIznos();
				}
			}
		}
		if(x == 2){
			for(NaplatnoMesto nm : naplatnaMesta){
				for(Prolazak p : nm.getProlasci()){
					suma++;
				}
			}
		}
		if(x == 3){
			for(NaplatnoMesto nm : naplatnaMesta){
				for(Prolazak p : nm.getProlasci()){
					if(p.getVreme().after(datum) )
					suma += p.getIznos();
				}
			}
		}
		if(x == 4){
			for(NaplatnoMesto nm : naplatnaMesta){
				for(Prolazak p : nm.getProlasci()){
					if(p.getVreme().after(datum) )
					suma ++;
				}
			}
		}
		
		return suma;
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
	
	public ArrayList<Korisnik> getZaposleniUStanici() {
		return zaposleniUStanici;
	}

	public void setZaposleniUStanici(ArrayList<Korisnik> zaposleniUStanici) {
		this.zaposleniUStanici = zaposleniUStanici;
	}
	public Korisnik dobaviSefa(){
		for(Korisnik k : zaposleniUStanici){
			if(k.getTipKorisnika() == TipKorisnika.SEF_STANICE){
				return k;
			}
		}
		return null;
	}
	
		
}
