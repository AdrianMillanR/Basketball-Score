package com.adrian.basketballscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.adrian.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    enum TypeScore{
        LOCAL, VISITANT
    }


    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel= new ViewModelProvider(this).get(MainViewModel.class);

        binding.localScore.setText(viewModel.getLocalScore().toString());
        binding.visitantScore.setText(viewModel.getVisitantScore().toString());

        events();
    }

    private void events(){
        binding.localPlusOne.setOnClickListener(v -> {
            viewModel.plusScore(1,TypeScore.LOCAL);
            binding.localScore.setText(viewModel.getLocalScore().toString());
        });

        binding.localPlusTwo.setOnClickListener(v -> {
            viewModel.plusScore(2,TypeScore.LOCAL);
            binding.localScore.setText(viewModel.getLocalScore().toString());
        });

        binding.visitantPlusOne.setOnClickListener(v -> {
            viewModel.plusScore(1,TypeScore.VISITANT);
            binding.visitantScore.setText(viewModel.getVisitantScore().toString());
        });

        binding.visitantPlusTwo.setOnClickListener(v -> {
            viewModel.plusScore(2,TypeScore.VISITANT);
            binding.visitantScore.setText(viewModel.getVisitantScore().toString());
        });

        binding.localMinusOne.setOnClickListener(v -> {
            viewModel.minusScore(1,TypeScore.LOCAL);
            binding.localScore.setText(viewModel.getLocalScore().toString());
        });
        binding.visitantMinusOne.setOnClickListener(v -> {
            viewModel.minusScore(1,TypeScore.VISITANT);
            binding.visitantScore.setText(viewModel.getVisitantScore().toString());
        });

        binding.buttonRefresh.setOnClickListener(v -> {
            viewModel.resetScore();
            binding.localScore.setText(viewModel.getLocalScore().toString());
            binding.visitantScore.setText(viewModel.getVisitantScore().toString());
        });

        binding.finalScoreButton.setOnClickListener(v -> {
            goFinalScore();
        });
    }

    private void goFinalScore(){
        Intent intent= new Intent(this, FinalScoreActivity.class);
        intent.putExtra(FinalScoreActivity.LOCAL_SCORE_KEY, viewModel.getLocalScore());
        intent.putExtra(FinalScoreActivity.VISITANT_SCORE_KEY, viewModel.getVisitantScore());
        startActivity(intent);
    }
}