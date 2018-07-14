package model;

public class ElektronskoNapMesto extends NaplatnoMesto {

	public ElektronskoNapMesto()
	{
		
	}
	
	@Override
	public boolean naplati(TipVozila tipVozila, Valuta valuta, NaplatnaStanica ulaz) {
		return true;

	}
	
	public static void skenirajTag()
	{
		
	}

}
