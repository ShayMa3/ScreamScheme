package com.example.sma51.screamscheme;

public class Damage {
	private int dmg, cd;
	private String name;

	public Damage (String name, int dmg, int cd) {
		this.name = name;
		this.dmg = dmg;
		this.cd = cd;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getCd() {
		return dmg;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
