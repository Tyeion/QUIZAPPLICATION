package com.example.quizapplication1;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0, questionAttempted=1,currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1Btn.getText().toString().trim()))
                {
                currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option2Btn.getText().toString().trim()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option3Btn.getText().toString().trim()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option4Btn.getText().toString().trim()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
       TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
       Button restartQuizBtn= bottomSheetView.findViewById(R.id.idBtnRestart);
       scoreTV.setText("Your Score is \n"+currentScore+"\10");
       restartQuizBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               currentPos = random.nextInt(quizModelArrayList.size());
               setDataToViews(currentPos);
               questionAttempted=0;
               currentScore = 0;
               bottomSheetDialog.dismiss();
               currentScore=0;

           }
       });

       bottomSheetDialog.setCancelable(false);
       bottomSheetDialog.setContentView(bottomSheetView);
       bottomSheetDialog.show();
    }


    private void setDataToViews(int currentPos)
    {
        questionNumberTV.setText("Questions Attempted: "+questionAttempted+"/10");
     if (questionAttempted==10)
     {
         showBottomSheet();
     }
     else {
         questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
         option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
         option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
         option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
         option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
     }
    }


    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
    quizModelArrayList.add(new QuizModel("What is the Capital Of India?","Chandigarh","Kolkata","Banglore","New Delhi","New Delhi"));
    quizModelArrayList.add(new QuizModel("Who invented Computer?","Charles Babbage","Tim Berners lee","Larry Page","Vint Cerf","Charles Babbage"));
    quizModelArrayList.add(new QuizModel("India lies in which continent?","Africa","Asia","Europe","Australia","Asia"));
    quizModelArrayList.add(new QuizModel("Most Widely Spoken language in the world?","Chinese","Hindi","English","Russian","Chinese"));
    quizModelArrayList.add(new QuizModel("Gateway Of India is Located at?","Chennai","Lucknow","Mumbai","Delhi","Mumbai"));
    quizModelArrayList.add(new QuizModel("Hitler party which came into power in 1933 is known as?","Ku-klux-Klan","Democratic Party","Nazi Party","Labour Party","Nazi Party"));
    quizModelArrayList.add(new QuizModel("Who invented the printing press?","Galielo","Johannes Gutenberg","Adolf Simon","John peters","Johannes Gutenberg"));
    quizModelArrayList.add(new QuizModel("Saina Nehwal is Associated with which sports?","Cricket","Badminton","Swimming","Football","Badminton"));
    quizModelArrayList.add(new QuizModel("Wimbledon is associated with which sports?","Cricket","Tennis","Swimming","Football","Tennis"));
    quizModelArrayList.add(new QuizModel("Who invented Pencilin?","Alexander Fleming","Loius Pasteur","Ernst Chain","Edward Jenner","Alexander Fleming"));
    quizModelArrayList.add(new QuizModel("Who discovered Pasteurization?","Alexander Fleming","Loius Pasteur","Ernst Chain","Edward Jenner","Louis Pasteur"));
    quizModelArrayList.add(new QuizModel("Who invented C Language?","Ken Thompson","James gosling","Bjarne Stroustrup","Dennis Ritchie","Dennis Ritchie"));
    quizModelArrayList.add(new QuizModel("Goitre is caused by the deficieny of?","Vitamins","Calcium","Iron","Iodine","Iodine"));
    quizModelArrayList.add(new QuizModel("How many rings does an olympic ring have?","4","5","6","8","5"));
    quizModelArrayList.add(new QuizModel("Olympics held after every _____ years?","4","5","6","8","4"));
    quizModelArrayList.add(new QuizModel("Who is the first President of India?","Dr.Rajendra Prasad","Sardar Vallabh Bhai Patel","Ram Nath Kovind","Pratibha Patel","Dr.Rajendra Prasad"));


    }
}