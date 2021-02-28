package com.adrian.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.adrian.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    enum TypeScore{
        LOCAL, VISITANT
    }

    private Integer localScore=0;
    private Integer visitantScore=0;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.localScore.setText(localScore.toString());
        binding.visitantScore.setText(visitantScore.toString());

        events();
    }

    private void events(){
        binding.localPlusOne.setOnClickListener(v -> {
            plusScore(1,TypeScore.LOCAL);
        });

        binding.localPlusTwo.setOnClickListener(v -> {
            plusScore(2,TypeScore.LOCAL);
        });

        binding.visitantPlusOne.setOnClickListener(v -> {
            plusScore(1,TypeScore.VISITANT);
        });

        binding.visitantPlusTwo.setOnClickListener(v -> {
            plusScore(2,TypeScore.VISITANT);
        });

        binding.localMinusOne.setOnClickListener(v -> {
            minusScore(1,TypeScore.LOCAL);
        });
        binding.visitantMinusOne.setOnClickListener(v -> {
            minusScore(1,TypeScore.VISITANT);
        });

        binding.buttonRefresh.setOnClickListener(v -> {
            resetScore();
        });

        binding.finalScoreButton.setOnClickListener(v -> {
            goFinalScore();
        });
    }

    private void plusScore(int numberPoints, TypeScore typescore){
        switch (typescore){
            case VISITANT:
                visitantScore+=numberPoints;
                binding.visitantScore.setText(visitantScore.toString());
                break;
            case LOCAL:
                localScore+=numberPoints;
                binding.localScore.setText(localScore.toString());
                break;
        }
    }

    private void minusScore(int numberPoints, TypeScore typescore){
        switch (typescore){
            case VISITANT:
                if(visitantScore>0){
                    visitantScore-=numberPoints;
                    binding.visitantScore.setText(visitantScore.toString());
                }
                break;
            case LOCAL:
                if(localScore>0){
                    localScore-=numberPoints;
                    binding.localScore.setText(localScore.toString());
                }
                break;

        }
    }

    private void resetScore(){
        localScore=0;
        visitantScore=0;
        binding.localScore.setText(localScore.toString());
        binding.visitantScore.setText(visitantScore.toString());
    }

    private void goFinalScore(){
        Intent intent= new Intent(this, FinalScoreActivity.class);
        intent.putExtra(FinalScoreActivity.LOCAL_SCORE_KEY, localScore);
        intent.putExtra(FinalScoreActivity.VISITANT_SCORE_KEY, visitantScore);
        startActivity(intent);
    }
}