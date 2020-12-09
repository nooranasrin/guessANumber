package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private int guessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setGuessNumber();
    }

    private void setGuessNumber() {
        Random rand = new Random();
        this.guessNumber = rand.nextInt((10 - 1) + 1) + 1;
    }

    public void guess(View view) {
        final EditText guessedNumberView = findViewById(R.id.guessedNumber);
        double guessedNumber = Double.parseDouble(guessedNumberView.getText().toString());
        if (this.guessNumber == guessedNumber) {
            Toast.makeText(getApplicationContext(), "You Guessed It Right", Toast.LENGTH_SHORT).show();
            this.setGuessNumber();
            Toast.makeText(getApplicationContext(), "I Guessed a new number, Try!!", Toast.LENGTH_SHORT).show();
            return;
        }
        String text = "The Guessed Number Is Low";
        if (this.guessNumber < guessedNumber) {
            text = "The Guessed Number Is High";
        }
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}