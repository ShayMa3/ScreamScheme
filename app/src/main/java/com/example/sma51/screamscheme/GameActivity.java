package com.example.sma51.screamscheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView textHeroName, textHeroHp, textBossName, textBossHp;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Hero hero = new Hero("name", 1);

        Intent i = getIntent();
        name = i.getStringExtra("name");

        wireWidgets();
        displayHeroName();
        
    }

    private void displayHeroName() {
        textHeroName.setText(name);
    }

    private void wireWidgets() {
        textHeroName = (TextView) findViewById(R.id.text_hero_name);
        textHeroHp = (TextView) findViewById(R.id.text_hero_hp);
        textBossName = (TextView) findViewById(R.id.text_boss_name);
        textBossHp = (TextView) findViewById(R.id.text_boss_hp);
    }
}
