package logika;

import model.Centrala;
import model.Korisnik;
import model.TipKorisnika;

public class Prijavljivanje {
	
	public static Korisnik prijaviSe(String korisnickoIme, String lozinka)
	{
		Centrala centrala = Centrala.getInstance();
		
		for (Korisnik korisnik : centrala.getKorisnici()) {
			if (korisnik.getKorisnickoIme().equals(korisnickoIme) &&
					korisnik.getLozinka().equals(lozinka))
			{
				return korisnik;
			}
		}
		return null;
	}
}
