package model;

import java.util.ArrayList;

public class Centrala {
	// Singleton
	
	private ArrayList<Cenovnik> cenovnici = new ArrayList<Cenovnik>();
	private ArrayList<Deonica> deonice = new ArrayList<Deonica>();
	private ArrayList<NaplatnaStanica> naplatneStanice = new ArrayList<NaplatnaStanica>();
	private ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	
	
	private static Centrala centrala = null;
	
	private Centrala() 
	{
		
	}
	
	public static Centrala getInstance()
	{
		if (centrala == null)
			centrala = new Centrala();
		
		return centrala;
	}
	
	
	
	
	public static void dodajKorisnika()
	{
		
	}
	public static void obrisiKorisnika()
	{
		
	}
	public static void izmeniKorisnika()
	{
		
	}
	public static void dodajNaplatnuStanicu()
	{
		
	}
	public static void izmeniNaplatnuStanicu()
	{
		
	}
	public static void obrisiNaplatnuStanicu()
	{
		
	}
	public static void dodajDeonicu()
	{
		
	}
	public static void obrisiDeonicu()
	{
		
	}
	public static void izmeniDeonicu()
	{
		
	}

	public ArrayList<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(ArrayList<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}

	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}

	public ArrayList<NaplatnaStanica> getNaplatneStanice() {
		return naplatneStanice;
	}

	public void setNaplatneStanice(ArrayList<NaplatnaStanica> naplatneStanice) {
		this.naplatneStanice = naplatneStanice;
	}

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public static Centrala getCentrala() {
		return centrala;
	}

	public static void setCentrala(Centrala centrala) {
		Centrala.centrala = centrala;
	}
	
}