package com.example.android.depressiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
    TextView TestResult;
    TextView Disclaimer;
    Button viewRec;
    int nilaiInt;
    ImageView ScoreRange;
    String getName;
    String getEmo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TestResult = (TextView) findViewById(R.id.TestResult);
        Disclaimer = (TextView) findViewById(R.id.Disclaimer);
        ScoreRange = (ImageView) findViewById(R.id.ScoreRange);

        //MainMenu = findViewById(R.id.ButtonMenu);

        getName = getIntent().getStringExtra("nameofuser");
        nilaiInt = getIntent().getIntExtra("nilai", 0);
        getEmo = getIntent().getStringExtra("voiceemotion");

        if (nilaiInt <= 4) {
            TestResult.setText("Hi " + getName + ", the emotion detected in your voice is " + getEmo + " and your total score is " + nilaiInt +
                    ". This indicates that you have no depression. ");
        } else if (nilaiInt <= 9) {
            TestResult.setText("Hi " + getName + ", the emotion detected in your voice is " + getEmo + " and your total score is " + nilaiInt +
                    ". This indicates that you may have mild depression. Please contact the hotline numbers if your symptoms worsen and affects your daily activities. ");
        } else if (nilaiInt <= 14) {
            TestResult.setText("Hi " + getName + ", the emotion detected in your voice is " + getEmo + " and your total score is " + nilaiInt +
                    ". This indicates that you may have moderate depression. We gladly suggest you to meet your doctor.");
        } else if (nilaiInt <= 22) {
            TestResult.setText("Hi " + getName + ", the emotion detected in your voice is " + getEmo + " and your total score is " + nilaiInt +
                    ". This indicates that you may have moderate to severe sepression. We gladly suggest you to meet your doctor.");
        } else if (nilaiInt > 22) {
            TestResult.setText("Hi " + getName + ", the emotion detected in your voice is " + getEmo + " and your total score is " + nilaiInt +
                    ". This indicates that you have severe depression. Please meet your doctor to get necessary treatment. ");
        }



        //Disclaimer.setText("PHQ-9, Patient Health Questionnaire 9:-" + " Developed by Drs Robert L Spitzer, Janet B.W. Williams, Kurt Kroenke and colleages, with an educational grant from Pfizer Inc."
        //+ " No permission required to reproduce, translate, display or contribute.");


        viewRec = (Button) findViewById(R.id.recList);
        viewRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(getApplicationContext(), ReccomendActivity.class);


                startActivity(r);
            }
        });
    }
}