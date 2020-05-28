package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    ArrayList<Integer> numbers = new ArrayList<>();
    Button start;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    TextView question;
    TextView result;
    int points = 0;
    int round = 0;

    ArrayList<List<String>> answersList;
    List<String> questionsList;
    List<String> Answers1Question;
    List<String> Answers2Question;
    List<String> Answers3Question;
    List<String> Answers4Question;
    List<String> Answers5Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        start = findViewById(R.id.startQuizButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        setContentView(R.layout.quiz_layout);
        setArrays();
        quiz();
    }

    private void quiz() {
        question = findViewById(R.id.questionView);
        answer1 = findViewById(R.id.button1);
        answer2 = findViewById(R.id.button2);
        answer3 = findViewById(R.id.button3);
        answer4 = findViewById(R.id.button4);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRound(1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRound(2);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRound(3);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRound(4);
            }
        });

        startRound();
    }

    private void checkRound(int number) {
        if (numbers.size()<5 && number == Integer.parseInt(answersList.get(round).get(4))) {
            points +=1;
            startRound();
        } else if (numbers.size()<5 && number != Integer.parseInt(answersList.get(round).get(4))) {
            startRound();
        } else if (numbers.size() == 5) {
            endQuiz();
        }
    }

    @SuppressLint("SetTextI18n")
    private void endQuiz() {
        setContentView(R.layout.end_quiz);
        result = findViewById(R.id.quizResult);
        result.setText(("Zdobyłeś") + points + " na " + questionsList.size());
    }

    void startRound() {
        round = new Random().nextInt(5);
        if (!numbers.contains(round)){
            numbers.add(round);
            question.setText(questionsList.get(round));
            answer1.setText(answersList.get(round).get(0));
            answer2.setText(answersList.get(round).get(1));
            answer3.setText(answersList.get(round).get(2));
            answer4.setText(answersList.get(round).get(3));
        } else {
            startRound();
        }
    }

    private void setArrays() {
        String[] questions = getResources().getStringArray(R.array.questions);
        questionsList = Arrays.asList(questions);

        String[] answers1 = getResources().getStringArray(R.array.Answers1Question);
        String[] answers2 = getResources().getStringArray(R.array.Answers2Question);
        String[] answers3 = getResources().getStringArray(R.array.Answers3Question);
        String[] answers4 = getResources().getStringArray(R.array.Answers4Question);
        String[] answers5 = getResources().getStringArray(R.array.Answers5Question);

        Answers1Question = Arrays.asList(answers1);
        Answers2Question = Arrays.asList(answers2);
        Answers3Question = Arrays.asList(answers3);
        Answers4Question = Arrays.asList(answers4);
        Answers5Question = Arrays.asList(answers5);

        answersList = new ArrayList<>();

        answersList.add(Answers1Question);
        answersList.add(Answers2Question);
        answersList.add(Answers3Question);
        answersList.add(Answers4Question);
        answersList.add(Answers5Question);
    }
}
