package model;

import java.util.Date;
import java.util.ArrayList;

public class NaplatnaStanica {
	private String naziv;
	private Centrala centrala;
	private ArrayList<Deonica> deonicaIzlaz = new ArrayList<Deonica>();
	private ArrayList<Deonica> deonicaUlaz = new ArrayList<Deonica>();
	private ArrayList<NaplatnoMesto> naplatnaMesta = new ArrayList<NaplatnoMesto>();
	private ArrayList<Korisnik> zaposleniUStanici = new ArrayList<Korisnik>();
	
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
	

	public NaplatnaStanica(String naziv, Centrala centrala, ArrayList<NaplatnoMesto> naplatnaMesta,
			ArrayList<Korisnik> zaposleniUStanici) {
		super();
		this.naziv = naziv;
		this.centrala = centrala;
		this.naplatnaMesta = naplatnaMesta;
		this.zaposleniUStanici = zaposleniUStanici;
	}
	
	

	public NaplatnaStanica(String naziv, Centrala centrala, ArrayList<Deonica> deonicaIzlaz,
			ArrayList<Deonica> deonicaUlaz, ArrayList<NaplatnoMesto> naplatnaMesta,
			ArrayList<Korisnik> zaposleniUStanici) {
		super();
		this.naziv = naziv;
		this.centrala = centrala;
		this.deonicaIzlaz = deonicaIzlaz;
		this.deonicaUlaz = deonicaUlaz;
		this.naplatnaMesta = naplatnaMesta;
		this.zaposleniUStanici = zaposleniUStanici;
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

	public Centrala getCentrala() {
		return centrala;
	}

	public void setCentrala(Centrala centrala) {
		this.centrala = centrala;
	}

	public ArrayList<Deonica> getDeonicaIzlaz() {
		return deonicaIzlaz;
	}

	public void setDeonicaIzlaz(ArrayList<Deonica> deonicaIzlaz) {
		this.deonicaIzlaz = deonicaIzlaz;
	}

	public ArrayList<Deonica> getDeonicaUlaz() {
		return deonicaUlaz;
	}

	public void setDeonicaUlaz(ArrayList<Deonica> deonicaUlaz) {
		this.deonicaUlaz = deonicaUlaz;
	}

	@Override
	public boolean equals(Object obj) {
		NaplatnaStanica np = (NaplatnaStanica) obj;
		if (np.getNaziv().equals(this.getNaziv()))
			return true;
		return false;
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
