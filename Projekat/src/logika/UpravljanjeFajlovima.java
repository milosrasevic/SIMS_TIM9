package logika;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Centrala;
import model.Korisnici;
import model.Korisnik;

public class UpravljanjeFajlovima {
	// TODO metode bacaju izuzetke, mozda ih treba obraditi sa try catch
	
	static String fajl_korisnici = "src/reprozitorijum/korisnici.json";
	static ObjectMapper mapper = new ObjectMapper();
	
	static Centrala centrala = Centrala.getInstance();
	static Korisnici korisnici = Korisnici.getInstance();
	
	public void ucitajKorisnike() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * Cita korisnike iz json fajla i mapira ih prvo na klasu Korisnici, a zatim napuni
		 * listu korisnika u centrali
		 * */
		korisnici = mapper.readValue(new File(fajl_korisnici), Korisnici.class);
		centrala.setKorisnici(korisnici.getKorisnici());
	}
	
	public void azurirajKorisnike(ArrayList<Korisnik> listaKorisnika) throws JsonGenerationException, JsonMappingException, IOException {
		/*
		 * Upisuje korisnike u json fajl
		 * listaKorisnika - lista korisnika koje treba sacuvati
		 * */
		mapper.writeValue(new File(fajl_korisnici), listaKorisnika);
	}
	
	public void dodajKorisnika(Korisnik korisnik) throws JsonGenerationException, JsonMappingException, IOException {
		/*
		 * Dodaje korisnika listi klase korisnici, zatim listi centrale, i onda ga upise u fajl
		 * */
		ArrayList<Korisnik> lista_korisnika = korisnici.getKorisnici();
		lista_korisnika.add(korisnik);
		korisnici.setKorisnici(lista_korisnika);
		
		ArrayList<Korisnik> lista_korisnika_centrale = centrala.getKorisnici();
		lista_korisnika_centrale.add(korisnik);
		centrala.setKorisnici(lista_korisnika);
		
		azurirajKorisnike(korisnici.getKorisnici());
	}
	
	public void obrisiKorisnika(Korisnik korisnik) throws JsonGenerationException, JsonMappingException, IOException {
		korisnici.getKorisnici().remove(korisnik);
		centrala.getKorisnici().remove(korisnik);
		azurirajKorisnike(korisnici.getKorisnici());
	}
}
