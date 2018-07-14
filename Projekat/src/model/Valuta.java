package model;


public enum Valuta {
	RSD,
	EUR;
	
	public static Valuta strToValuta(String s)
	{
		switch (s) {
		case "RSD":
			return RSD;
		case "EUR":
			return EUR;
		default:
			return null;
		}
	}
}
