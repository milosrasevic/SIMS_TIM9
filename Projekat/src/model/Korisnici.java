package model;
import java.util.ArrayList;

public class Korisnici {
	/*
	 * singleton
	 * Wrapper klasa, sluzi kod upisa i citanja korisnika iz fajla, jedini atribut je lista korisnika
	 * */
	ArrayList<Korisnik> korisnici;

	private static Korisnici instanca_Korisnici = null;
	public Korisnici() {
		super();
		this.korisnici = new ArrayList<Korisnik>();
	}
	public static Korisnici getInstance()
	{
		if (instanca_Korisnici == null)
			instanca_Korisnici = new Korisnici();
		
		return instanca_Korisnici;
	}

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
}
