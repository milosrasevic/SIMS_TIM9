package model;

import java.util.ArrayList;

public enum TipVozila {
	K1A,
	K1,
	K2,
	K3,
	K4;
	
	public static ArrayList<TipVozila> getTipovi()
	{
		ArrayList<TipVozila> tipovi = new ArrayList<TipVozila>();
		
		for (TipVozila tip : TipVozila.values()) {
			tipovi.add(tip);
		}
		return tipovi;
	}
	
	public static String getSliku(TipVozila tip) {
		
		switch (tip) {
		case K1A:
			return "slike/K1A.jpg";
		case K1:
			return "slike/K1.jpg";
		case K2:
			return "slike/K2.jpg";
		case K3:
			return "slike/K3.jpg";
		case K4:
			return "slike/K4.jpg";

		default:
			break;
		}
		
		return "";
	}
	
	public static TipVozila strToTip(String s)
	{
		switch (s) {
		case "K1A":
			return 	K1A;
		case "K1":
			return K1;
		case "K2":
			return K2;
		case "K3":
			return K3;
		case "K4":
			return K4;

		default:
			return null;
		}
	}
}
