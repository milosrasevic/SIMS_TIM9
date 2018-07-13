package logika;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Centrala;
import model.Deonica;
import model.Deonice;
import model.Korisnici;
import model.Korisnik;

public class UpravljanjeFajlovima {
	// TODO metode bacaju izuzetke, mozda ih treba obraditi sa try catch
	
	static String fajl_korisnici = "src/reprozitorijum/korisnici.json";
	static String fajl_deonice = "src/reprozitorijum/deonice.json";
	static ObjectMapper mapper = new ObjectMapper();
	
	static Centrala centrala = Centrala.getInstance();
	static Korisnici korisnici = Korisnici.getInstance();
	static Deonice deonice = Deonice.getInstance();
	
	public void ucitajDeonice() throws JsonParseException, JsonMappingException, IOException {
		deonice = mapper.readValue(new File(fajl_deonice), Deonice.class);
		centrala.setDeonice(deonice.getDeonice());
	}
	
	public void azurirajDeonice(ArrayList<Deonica> listaDeonica) throws JsonParseException, JsonMappingException, IOException {
		mapper.writeValue(new File(fajl_deonice), listaDeonica);
	}
	
	public void dodajDeonicu(Deonica d) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Deonica> listaDeonica = centrala.getDeonice();
		listaDeonica.add(d);
		centrala.setDeonice(listaDeonica);

		deonice.setDeonice(listaDeonica);
		azurirajDeonice(deonice.getDeonice());
	}
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
		
		centrala.setKorisnici(lista_korisnika);
		
		azurirajKorisnike(korisnici.getKorisnici());
	}
	
	public void obrisiKorisnika(Korisnik korisnik) throws JsonGenerationException, JsonMappingException, IOException {
		korisnici.getKorisnici().remove(korisnik);
		centrala.getKorisnici().remove(korisnik);
		azurirajKorisnike(korisnici.getKorisnici());
	}
}
