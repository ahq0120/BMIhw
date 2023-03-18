package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(calBMI);

        Button clearButton = (Button) findViewById(R.id.button2);
        clearButton.setOnClickListener(clearall);

    }

    private View.OnClickListener calBMI = new View.OnClickListener() {
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText fheight = (EditText) findViewById(R.id.editTextNumber);
            EditText fweight = (EditText) findViewById(R.id.editTextNumber2);
            double sheight = Double.parseDouble(fheight.getText().toString()) / 100;
            double sweight = Double.parseDouble(fweight.getText().toString());
            double BMI = sweight / (sheight * sheight);
            TextView result = (TextView) findViewById(R.id.lblOutput);
            result.setText(nf.format(BMI));

            TextView suggest = (TextView) findViewById(R.id.lblOutput);
            if (BMI>24.00){
            suggest.setTextColor(Color.RED);
             }
             else if (BMI<18.50){
                suggest.setTextColor(Color.BLUE);
             }
             else {
               suggest.setTextColor(Color.GREEN);
            }

        }
    };
    private View.OnClickListener clearall = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText fheight = (EditText) findViewById(R.id.editTextNumber);
            EditText fweight = (EditText) findViewById(R.id.editTextNumber2);
            TextView result = (TextView) findViewById(R.id.lblOutput);

            fheight.setText("");
            fweight.setText("");
            result.setText("");
        }
    };
}





