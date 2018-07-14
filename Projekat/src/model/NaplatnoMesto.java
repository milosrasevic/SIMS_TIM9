package model;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize(as = ObicnoNapMesto.class)
public abstract class NaplatnoMesto {
	private NaplatnaStanica naplatnaStanica;
	private int redniBroj;
	private Rampa rampa;
	private ArrayList<Kvar> kvarovi = new ArrayList<Kvar>();
	private ArrayList<Prolazak> prolasci = new ArrayList<Prolazak>();
	private ArrayList<Korisnik> zaposleniUMestu = new ArrayList<Korisnik>();

	public NaplatnoMesto() {

	}

	public NaplatnoMesto(int redniBroj, Rampa rampa) {
		super();
		this.redniBroj = redniBroj;
		this.rampa = rampa;
	}

	public NaplatnoMesto(int redniBroj, Rampa rampa, ArrayList<Kvar> kvarovi) {
		super();
		this.redniBroj = redniBroj;
		this.rampa = rampa;
		this.kvarovi = kvarovi;
	}
	
	public NaplatnoMesto(int redniBroj, ArrayList<Kvar> kvarovi, ArrayList<Prolazak> prolasci, ArrayList<Korisnik> zaposleni) {
		super();
		this.redniBroj = redniBroj;
		this.kvarovi = kvarovi;
		this.prolasci = prolasci;
		this.zaposleniUMestu = zaposleni;
	}
	
	
	//TODO : proveri nacin na koji se odredjuju zaposleni u mestu, i da li treba da postoje u konstruktoru
	public NaplatnoMesto(int redniBroj, Rampa rampa, ArrayList<Kvar> kvarovi, ArrayList<Prolazak> prolasci) {
		super();
		this.redniBroj = redniBroj;
		this.rampa = rampa;
		this.kvarovi = kvarovi;
		this.prolasci = prolasci;
	}
	

	public NaplatnoMesto(NaplatnaStanica naplatnaStanica, int redniBroj, Rampa rampa, ArrayList<Kvar> kvarovi,
			ArrayList<Prolazak> prolasci, ArrayList<Korisnik> zaposleniUMestu) {
		super();
		this.naplatnaStanica = naplatnaStanica;
		this.redniBroj = redniBroj;
		this.rampa = rampa;
		this.kvarovi = kvarovi;
		this.prolasci = prolasci;
		this.zaposleniUMestu = zaposleniUMestu;
	}

	public NaplatnoMesto(int redniBroj) {
		super();
		this.redniBroj = redniBroj;
	}

	public static void izvestajBrVozila() {

	}

	public static void izvestajNaplacenIznos() {

	}

	public static void izvestajKvarovi() {

	}

	public static void promeniStanje(StanjeNaplatnogMesta stanje) {

	}

	public abstract boolean naplati(TipVozila tipVozila, Valuta valuta, NaplatnaStanica ulaz);

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Rampa getRampa() {
		return rampa;
	}

	public void setRampa(Rampa rampa) {
		this.rampa = rampa;
	}

	public ArrayList<Kvar> getKvarovi() {
		return kvarovi;
	}

	public void setKvarovi(ArrayList<Kvar> kvarovi) {
		this.kvarovi = kvarovi;
	}

	public ArrayList<Prolazak> getProlasci() {
		return prolasci;
	}

	public void setProlasci(ArrayList<Prolazak> prolasci) {
		this.prolasci = prolasci;
	}

	public ArrayList<Korisnik> getZaposleniUMestu() {
		return zaposleniUMestu;
	}

	public void setZaposleniUMestu(ArrayList<Korisnik> zaposleniUMestu) {
		this.zaposleniUMestu = zaposleniUMestu;
	}
	
	
	public NaplatnaStanica getNaplatnaStanica() {
		return naplatnaStanica;
	}

	public void setNaplatnaStanica(NaplatnaStanica naplatnaStanica) {
		this.naplatnaStanica = naplatnaStanica;
	}

	public  double getCenaVozila(TipVozila tipVozila, Valuta valuta, NaplatnaStanica ulaz)
	{
		ArrayList<Deonica> deoniceIzlaz = this.naplatnaStanica.getDeonicaIzlaz();
		
		for (Deonica deonica : deoniceIzlaz) {
			if (deonica.getUlaznaStanica().equals(ulaz))
			{
				for (Cenovnik cenovnik : deonica.getCenovnici()) {
					for (CenovnikVozilo c : cenovnik.getCenovniciVozila()) {
						if (c.getValuta().equals(valuta) && c.getTipVozila().equals(tipVozila))
						{
							return c.getCena();
						}
					}
				}
			}
		}
		return 0;
		
	}
	
}
