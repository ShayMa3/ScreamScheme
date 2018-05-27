package com.example.sma51.screamscheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView textHeroName, textHeroHp, textBossName, textBossHp, textPoke, textSlap, textPunch, textStab, textPew, txvResult;
    private Boss boss1, boss2;
    private Hero hero;
    private Pleb pleb;
    private Damage poke, slap, punch, stab, pew;
    private String name;
    private long startTime, waitTime;
    private int plebTracker;
    private List<Pleb> plebSquad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hero = new Hero("name");
        boss1 = new Boss("Lv. 1 Boss", 50, 5);
        boss2 = new Boss("Lv. 2 Boss", 75, 15);
        pleb = new Pleb();
        poke = new Damage("poke", 1, 0);
        slap = new Damage("slap", 3, 2);
        punch = new Damage("punch", 5, 5);
        stab = new Damage("stab", 8, 10);
        pew = new Damage("pew", 10, 15);
        plebSquad = new ArrayList<Pleb>();
        plebSquad.add(new Pleb());
        plebSquad.add(new Pleb());
        plebSquad.add(new Pleb());
        plebSquad.add(new Pleb());
        plebTracker = 0;

        Intent i = getIntent();
        name = i.getStringExtra("name");

        wireWidgets();
        displayNames();
        displayCooldownBar();
        
    }

    private void wireWidgets() {
        textHeroName = (TextView) findViewById(R.id.text_hero_name);
        textHeroHp = (TextView) findViewById(R.id.text_hero_hp);
        textBossName = (TextView) findViewById(R.id.text_boss_name);
        textBossHp = (TextView) findViewById(R.id.text_boss_hp);
        textPoke = (TextView) findViewById(R.id.text_poke);
        textSlap = (TextView) findViewById(R.id.text_slap);
        textPunch = (TextView) findViewById(R.id.text_punch);
        textStab = (TextView) findViewById(R.id.text_stab);
        textPew = (TextView) findViewById(R.id.text_pew);
        txvResult = (TextView) findViewById(R.id.txvResult);
    }
    
    private void displayNames() {
        textHeroName.setText(name);
        textBossName.setText(boss.getName());
    }
    
    private void displayCooldownBar() {
        textPoke.setText("Poke - 0");
        textSlap.setText("Slap - 0");
        textPunch.setText("Punch - 0");
        textStab.setText("Stab - 0");
        textPew.setText("Pew - 0");
    }
    
    private void updateCooldownBar(Damage dmg) {
        if(dmg.getName().equals("slap")) {
            textPoke.setText("Slap - 5");
            wait(5000);
            textPoke.setText("Slap - 0");
        }
        else if(dmg.getName().equals("punch")) {
            textPoke.setText("Punch - 5");
            wait(5000);
            textPoke.setText("Punch - 0");
        }
        else if(dmg.getName().equals("stab")) {
            textPoke.setText("Stab - 5");
            wait(5000);
            textPoke.setText("Stab - 0");
        }
        else if(dmg.getName().equals("pew")) {
            textPoke.setText("Pew - 5");
            wait(5000);
            textPoke.setText("Pew - 0");
        }
    }
    
	public void getSpeechInput(View view) {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(intent, 10);
		} else {
			Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
		}
	}
    
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
			case 10:
			    if (resultCode == RESULT_OK && data != null)
				{
					ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					txvResult.setText(result.get(0));
                   //DAMAGE TRIGGER WORDS
                   //trigger word "poke"
                   if(result.get(0).equalsIgnoreCase("poke")){
                       txvResult.setText("You did 1 damage!");
                       if(plebTracker <= 3) {
                            plebSquad.get(plebTracker).takeDamage(1);
                            //make cooldowns and lock skills
                            if(plebSquad.get(plebTracker).getHp() <= 0) {
                                wait(2000);
                                txvResult.setText("pleb died!"); //show next pleb/boss
                            }
                        }
                        else {
                           wait(1000); 
                           txvResult.setText("You are now facing the boss!"); //make boss appear
                       }
                   }
                   //trigger word "slap"
                   if(result.get(0).equalsIgnoreCase("slap")){
                       txvResult.setText("You did 3 damage!");
                       if(plebTracker <= 3) {
                            plebSquad.get(plebTracker).takeDamage(3);
                            //make cooldowns and lock skills
                            if(plebSquad.get(plebTracker).getHp() <= 0) {
                                wait(2000);
                                txvResult.setText("pleb died!"); //show next pleb/boss
                            }
                        }
                        else {
                           wait(1000); 
                           txvResult.setText("You are now facing the boss!"); //make boss appear
                       }
                   }
                   //trigger word "punch"
                   if(result.get(0).equalsIgnoreCase("punch")){
                       txvResult.setText("You did 5 damage!);
                       if(plebTracker <= 3) {
                            plebSquad.get(plebTracker).takeDamage(5);
                            //make cooldowns and lock skills
                            if(plebSquad.get(plebTracker).getHp() <= 0) {
                                wait(2000);
                                txvResult.setText("pleb died!"); //show next pleb/boss
                            }
                        }
                        else {
                           wait(1000); 
                           txvResult.setText("You are now facing the boss!"); //make boss appear
                       }
                   }
                   //trigger word "stab"
                   if(result.get(0).equalsIgnoreCase("stab")){
                       txvResult.setText("You did 8 damage!");
                       if(plebTracker <= 3) {
                            plebSquad.get(plebTracker).takeDamage(8);
                            //make cooldowns and lock skills
                            if(plebSquad.get(plebTracker).getHp() <= 0) {
                                wait(2000);
                                txvResult.setText("pleb died!"); //show next pleb/boss
                            }
                        }
                        else {
                           wait(1000); 
                           txvResult.setText("You are now facing the boss!"); //make boss appear
                       }
                   }
                   //trigger word "pew"
                   if(result.get(0).equalsIgnoreCase("pew")){
                       txvResult.setText("You did 10 damage!");
                       if(plebTracker <= 3) {
                            plebSquad.get(plebTracker).takeDamage(10);
                            //make cooldowns and lock skills
                            if(plebSquad.get(plebTracker).getHp() <= 0) {
                                wait(2000);
                                txvResult.setText("pleb died!"); //show next pleb/boss
                            }
                        }
                        else {
                           wait(1000); 
                           txvResult.setText("You are now facing the boss!"); //make boss appear
                       }
                   }
                   //HEALTH TRIGGER WORDS
                   //trigger word  "help"
                   if(result.get(0).equalsIgnoreCase("help"));
		   	if(this.hp < 100) {
				this.hp+=10;
				txvResult.setText("You healed for 10 hp!");
				if(hp >= 100)
					hp = 100;
				textHeroHp.setText("HP: " + hp); //change to progress bar later
			}
			else {
				txvResult.setText("You were already at full hp");
			}
		   	//lock this skill for 30 sec
                   }
                   //trigger word "bless up"
                   if(result.get(0).equalsIgnoreCase("bless up")){
                        txvResult.setText("YOU HEALED FOR 50 HP!");   
			this.hp+=50;
			textHeroHp.setText("HP: " + hp);
		   	//lock this skill unti the next boss appears
                   }
		}
		break;
		}
	}

}
