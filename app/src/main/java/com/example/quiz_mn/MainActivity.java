package com.example.quiz_mn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int currentQuestionIndex = 0;

    private Question[] questions = new Question[] {
            new Question(R.string.q_activity, true),
            new Question(R.string.q_version, false),
            new Question(R.string.q_listener, true),
            new Question(R.string.q_resources, true),
            new Question(R.string.q_find_resources, false)
    };

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
                showCurrentQuestion();
            }
        });
    }




    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentQuestionIndex].isTrue();
        int messageId;
        if (userAnswer == correctAnswer)
            messageId = R.string.correct_answer;
        else
            messageId = R.string.incorrect_answer;
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }
    private void showCurrentQuestion() {
        questionTextView.setText(questions[currentQuestionIndex].getId());
    }
}