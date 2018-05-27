package com.example.sma51.screamscheme;

public class Pleb {
	private int hp, dmg;

	public Pleb () {
		this.hp = 25;
		this.dmg = 2;
	}

	public int getBasicAttackCooldown () {
		return 5;
	}

	public void takeDamage(int dmgDealt) {
		if(hp >= 0) {

				hp-=dmgDealt; //take the hp from the boss in the host activity and decide whether or not the boss is dead

		}
		else {
			hp = 0; //calculate that 0 hp = dead in the actual activity
		}
	}

	public int getDmg () {
		return dmg; //the host activity will subtract this from the character's hp
	}
	
	public int getHp() {
		return hp;
	}
}
