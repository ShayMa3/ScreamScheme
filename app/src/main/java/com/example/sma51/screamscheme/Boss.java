package com.example.sma51.screamscheme;

pubic class Boss {
	private int hp, basicAttackCd, specAttackCd, level, dmg;
	private String name;
	
	public Boss (String name, int hp, int dmg) {  //so when making level 1 boss it would be: Boss("nooby boss", 50, 5); 
		this.name = name;
		this.hp = hp;
		this.dmg = dmg;
	}

	public int getBasicAttackCooldown () {
		if(level == 1 || level == 2) {
			return 5;
		}
		return 0;
	}

	public int getSpecAttackCooldown () {
		if(level == 2) {
			return 15;
		}
	}

	public void takeDamage(int dmgDealt) {
		if(hp >= 0) {
			if(level == 1) {
				hp-=dmgDealt; //take the hp from the boss in the host activity and decide whether or not the boss is dead
			}
		}
		else {
			hp = 0; //calculate that 0 hp = dead in the actual activity
		}
	}

	public int dealDmg () {
		return dmg; //the host activity will subtract this from the character's hp
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	{
		
	public int getHp() {
		return hp;
	}
}

