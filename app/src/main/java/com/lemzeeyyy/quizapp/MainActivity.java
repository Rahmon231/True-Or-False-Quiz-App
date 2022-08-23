package com.lemzeeyyy.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.lemzeeyyy.quizapp.databinding.ActivityMainBinding;
import com.lemzeeyyy.quizapp.model.Question;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentQUestionIndex = 0 ;
    private Question[] questions = new Question[]{
            new Question(R.string.question_amendments,false),
            new Question(R.string.question_constitution,true),
            new Question(R.string.question_declaration,true),
            new Question(R.string.question_government,false),
            new Question(R.string.question_religion,true)

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getQuestion();

            binding.nextBtnID.setOnClickListener(view -> {
                if(currentQUestionIndex<questions.length-1) {
                    currentQUestionIndex++;
                    getQuestion();
                }

            });
            binding.prevBtnID.setOnClickListener(view -> {
                if(currentQUestionIndex>0){
                    currentQUestionIndex--;
                    getQuestion();
                }
            });
            binding.trueBtnID.setOnClickListener(view -> checkAnswer(true));
            binding.falseBtnID.setOnClickListener(view -> checkAnswer(false));
        }


    public void getQuestion(){
        binding.questionsTvID.setText(questions[currentQUestionIndex].getQuestionResId());
    }
    private void checkAnswer(boolean choice){
        boolean correctAnswer = questions[currentQUestionIndex].getAnsTrue();
        int messageId;
        if(correctAnswer == choice){
            messageId = R.string.correct_answer;
        }
        else {
            messageId = R.string.wrong_answer;
        }
        Snackbar.make(binding.imageView,messageId,Snackbar.LENGTH_SHORT)
                .show();
    }


}