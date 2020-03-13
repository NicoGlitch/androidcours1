package com.nbegin.exercicecours1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MAX = 10;
    private GuessNumber guessnumber;

    private EditText inputNumber;
    private Button buttonTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText_nbr1);
        buttonTry = findViewById(R.id.btn_compare);

        guessnumber = new GuessNumber(MAX);
        setListener();
    }
    private void setListener(){
        buttonTry.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }
    private void guess(){
        int guessNumber  = Integer.parseInt(inputNumber.getText().toString());
        GuessNumber.guessState result =  guessnumber.testNumber(guessNumber);

        if(result == GuessNumber.guessState.SMALLER){
    showHint("Votre nombre est plus grand.");
        }else if (result == GuessNumber.guessState.BIGGER){
            showHint("Votre nombre est plus grand.");
        }else{
            showHint("Bravo !, un autre nombre à été généré");
            guessnumber.generateNewNumber();
        }
    }
    private void showHint(String hint){
        Toast.makeText(this, hint, Toast.LENGTH_LONG).show();
    }
}
