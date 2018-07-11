package model;

import java.util.ArrayList;

public abstract class NaplatnoMesto {

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
	
	//TODO : proveri nacin na koji se odredjuju zaposleni u mestu, i da li treba da postoje u konstruktoru
	public NaplatnoMesto(int redniBroj, Rampa rampa, ArrayList<Kvar> kvarovi, ArrayList<Prolazak> prolasci) {
		super();
		this.redniBroj = redniBroj;
		this.rampa = rampa;
		this.kvarovi = kvarovi;
		this.prolasci = prolasci;
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

	public abstract void naplati();

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
	
}
