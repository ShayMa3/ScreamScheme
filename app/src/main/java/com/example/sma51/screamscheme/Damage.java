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

	public int setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getCd() {
		return dmg;
	}

	public int setCd(int cd) {
		this.cd = cd;
	}

	public int getName() {
		return dmg;
	}

	public int setName(String name) {
		this.name = name;
	}
}
