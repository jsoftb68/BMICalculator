package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButtonListenerMethod();
    }

    private void myButtonListenerMethod() {
        final EditText weightInput = (EditText)findViewById(R.id.weightInput);
        final EditText heightInput = (EditText)findViewById(R.id.heightInput);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(weightInput.getText().toString());
                float height = Float.parseFloat(heightInput.getText().toString());
                float bmi = weight / (height * height);
                ((EditText)findViewById(R.id.BMIResult)).setText(String.format("%.1f", bmi));
                ((TextView)findViewById(R.id.BMICategory)).setText(CategoryText(bmi));
            }
        });
    }

    private String CategoryText(float bmi) {
        String s = null;

        if (bmi >= 40)          s = "Very serverely obese";
        else if (bmi >= 35)     s = "Serverely obese";
        else if (bmi >= 30)     s = "Moderately obese";
        else if (bmi >= 25)     s = "Overweight";
        else if (bmi >= 18.5)   s = "Normal";
        else if (bmi >= 16)     s = "Underweight";
        else if (bmi >= 15)     s = "Severely underweight";
        else                    s = "Very severely underweight";

        return s;
    }
}