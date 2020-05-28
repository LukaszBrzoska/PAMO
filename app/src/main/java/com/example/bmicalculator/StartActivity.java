package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button bmi;
    Button calories;
    Button quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bmi = findViewById(R.id.buttonBMI);
        calories = findViewById(R.id.buttonCalories);
        quiz = findViewById(R.id.buttonQuiz);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runBmiCalculator();
            }
        });

        calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCaloriesCalculator();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runQuiz();
            }
        });
    }

    private void runQuiz() {
        Intent quiz = new Intent(this, QuizActivity.class);
        startActivity(quiz);
    }

    private void runCaloriesCalculator() {
        Intent calories = new Intent(this, CaloriesActivity.class);
        startActivity(calories);
    }


    void runBmiCalculator() {
        Intent bmi = new Intent(this, MainActivity.class);
        startActivity(bmi);
    }
}
