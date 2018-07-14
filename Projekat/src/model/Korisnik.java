package model;


public class Korisnik {
	
	private String korisnickoIme;
	private String lozinka;
	private TipKorisnika tipKorisnika;
	
	private ObicnoNapMesto naplatnoMesto;
	
	public Korisnik()
	{
		
	}
	
	public Korisnik(String korisnickoIme, String lozinka, TipKorisnika tipKorisnika) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public ObicnoNapMesto getNaplatnoMesto() {
		return naplatnoMesto;
	}

	public void setNaplatnoMesto(ObicnoNapMesto naplatnoMesto) {
		this.naplatnoMesto = naplatnoMesto;
	}
	
	
	

}
