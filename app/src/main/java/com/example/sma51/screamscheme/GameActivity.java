package com.example.sma51.screamscheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView textHeroName, textHeroHp, textBossName, textBossHp, textPoke, textSlap, textPunch, textStab, textPew;
    private Boss boss;
    private Hero hero;
    private Pleb pleb;
    private Damage poke, slap, punch, stab, pew;
    private String name;
    private long startTime, waitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hero = new Hero("name");
        boss = new Boss("Lv. 1 Boss", 50, 5);
        pleb = new Pleb();
        poke = new Damage("poke", 1, 0);
        slap = new Damage("slap", 3, 2);
        punch = new Damage("punch", 5, 5);
        stab = new Damage("stab", 8, 10);
        pew = new Damage("pew", 10, 15);

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
}
