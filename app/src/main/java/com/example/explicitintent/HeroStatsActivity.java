package com.example.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvStrength;
    TextView tvTechnicalProwess;
    Button btnLike;
    Button btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        tvName = findViewById(R.id.textViewName);
        tvStrength = findViewById(R.id.textViewStrength);
        tvTechnicalProwess = findViewById(R.id.textViewTechnicalProwess);
        btnDislike = findViewById(R.id.buttonDislike);
        btnLike = findViewById(R.id.buttonLike);

        // Get intent
        Intent i = getIntent();
        // Get the hero object first activity put in intent
        Hero hero = (Hero) i.getSerializableExtra("hero");

        // Use of getter of hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        // When button is LIKE is clicked, set the results
        // accordingly and finish() to close this act.
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "like");

                // Set results to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK , i);
                finish();
            }
        });

        // When button is DISLIKE clicked  , set results
        // accordingly and finish() to close this activity
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like" , "dislike");


                // Set results to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK , i);
                finish();

            }
        });



    }
}
