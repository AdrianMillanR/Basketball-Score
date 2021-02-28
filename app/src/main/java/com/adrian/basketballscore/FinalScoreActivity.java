package com.adrian.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adrian.basketballscore.databinding.ActivityFinalScoreBinding;

public class FinalScoreActivity extends AppCompatActivity {

    public static String LOCAL_SCORE_KEY= "localScore";
    public static String VISITANT_SCORE_KEY= "visitantScore";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFinalScoreBinding binding= ActivityFinalScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras= getIntent().getExtras();

        int localScore= extras.getInt(LOCAL_SCORE_KEY);
        int visitantScore= extras.getInt(VISITANT_SCORE_KEY);

        binding.textView2.setText(localScore+" - "+visitantScore);

        String resultText="";
        if (localScore > visitantScore) {
            resultText="Locals Win!!!";
        }else if(visitantScore > localScore){
            resultText="Visitants Win!!";
        }else{
            resultText="Tie...";
        }

        binding.textView3.setText(resultText);
    }
}