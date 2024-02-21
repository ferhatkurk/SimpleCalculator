package com.ferhatkurkcuoglu.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    EditText number1Text;
    EditText number2Text;
    TextView resultText;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        resultText = findViewById(R.id.resultText);
        sharedPreferences = this.getSharedPreferences("com.ferhatkurkcuoglu.simplecalculator", Context.MODE_PRIVATE);
        float storedNum = sharedPreferences.getFloat("storedNum",0);
        if (storedNum == 0){
            resultText.setText("0");
        }
        else{
            resultText.setText(String.valueOf(storedNum));
        }


    }
    public void sum(View view){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());
        float result = number1 + number2;
        resultText.setText(String.valueOf(result));
        sharedPreferences.edit().putFloat("storedNum",result).apply();

    }
    public void sub(View view){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());
        float result = number1 - number2;
        resultText.setText(String.valueOf(result));
        sharedPreferences.edit().putFloat("storedNum",result).apply();

    }
    public void multiply(View view){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());
        float result = number1 * number2;
        resultText.setText(String.valueOf(result));
        sharedPreferences.edit().putFloat("storedNum",result).apply();

    }
    public void divide(View view){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());
        float result = number1 / number2;
        resultText.setText(String.valueOf(result));
        sharedPreferences.edit().putFloat("storedNum",result).apply();

    }
    public void clear(View view){
        resultText.setText("");
        number1Text.setText("");
        number2Text.setText("");
    }
}