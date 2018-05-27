package com.example.sma51.screamscheme;

public class Hero {
	private int hp;
	private String name;

	public Hero (String name) {
		this.hp = 50;
		this.name = name;
	}

	public void takeDamage(int dmgDealt) {
		if(hp >= 0) {
				hp-=dmgDealt; //take the hp from the boss in the host activity and decide whether or not the boss is dead
		}
		else {
			hp = 0; //calculate that 0 hp = dead in the actual activity
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	{

	public void heal(int healAmt) {
		hp+=healAmt;
	}
		
	public int getHp() {
		return hp;
	}
}
