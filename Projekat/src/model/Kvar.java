package model;

import java.util.Date;

public class Kvar {
	
	private Date vreme;
	private VrstaKvara vrstaKvara;
	
	public Kvar()
	{
		
	}

	public Kvar(Date vreme, VrstaKvara vrstaKvara) {
		super();
		this.vreme = vreme;
		this.vrstaKvara = vrstaKvara;
	}

	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public VrstaKvara getVrstaKvara() {
		return vrstaKvara;
	}

	public void setVrstaKvara(VrstaKvara vrstaKvara) {
		this.vrstaKvara = vrstaKvara;
	}
	
}
