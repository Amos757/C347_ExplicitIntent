package com.example.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Getting response back from activity 2
    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvSuperman;
    TextView tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = findViewById(R.id.textViewSuperman);
        tvBatman = findViewById(R.id.textViewBatman);

        // Set listener to handle the clicking of superman textview
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object (strength and technical)
                Hero superman = new Hero("Superman" , 100, 60);
                Intent i =new Intent(MainActivity.this , HeroStatsActivity.class);

                //Put hero object in intent
                i.putExtra("hero" ,superman);
                startActivityForResult(i,requestCodeForSupermanStats);

            }
        });

        // Set listener to handle the clicking of batman textview
        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object (strength and technical)
                Hero batman  = new Hero("Batman" , 60 , 90);
                Intent i = new Intent(MainActivity.this , HeroStatsActivity.class);

                // Put hero object in intent
                i.putExtra("hero", batman);
                startActivityForResult(i, requestCodeForBatmanStats);

            }
        });

    }

    @Override protected void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode , resultCode , data);

        //Only handle when second activity closed normally , and contain something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                //Get data passed back from activity 2nd
                String like = data.getStringExtra("like");
                String statement = "";

                //If it is activity started by clicking
                // Superman , create corresponding String
                if (requestCode == requestCodeForSupermanStats) {
                    statement = "You" + like + "Superman";
                }

                //IF 2nd activity started by clicking
                // Batman , create a corresponding String
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }

                //TOAST to make text
                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();

            }
        }
    }
}
