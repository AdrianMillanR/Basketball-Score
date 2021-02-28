package com.adrian.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adrian.basketballscore.databinding.ActivityFinalScoreBinding;

public class FinalScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFinalScoreBinding binding= ActivityFinalScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}