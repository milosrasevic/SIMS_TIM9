package model;

import java.util.Calendar;
import java.util.Date;

public class ObicnoNapMesto extends NaplatnoMesto {
	
	public ObicnoNapMesto()
	{
		
	}

	@Override
	public boolean naplati(TipVozila tipVozila, Valuta valuta, NaplatnaStanica ulaz) {
		
		try {
			Date vreme = Calendar.getInstance().getTime();
			double iznos = getCenaVozila(tipVozila, valuta, ulaz);
			Prolazak prolazak = new Prolazak(vreme, iznos, tipVozila, valuta);
			super.getProlasci().add(prolazak);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void prinudnoSpustanje()
	{
		
	}
	
	public static void prinudnoPodizanje()
	{
		
	}
}
