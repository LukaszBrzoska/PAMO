package com.example.bmicalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    public void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {

            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
    }
}



    private void displayBMI(float bmi) {
        String bmiDisplay = "";

        if(Float.compare(bmi, 15f) <= 0) {
            bmiDisplay = getString(R.string.wyglodzenie);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0){
            bmiDisplay = getString(R.string.wychudzenie);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 18.5f) <= 0){
            bmiDisplay = getString(R.string.niedowaga);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 25f) <= 0){
            bmiDisplay = getString(R.string.pozadana_masa_ciala);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 30f) <= 0){
            bmiDisplay = getString(R.string.nadwaga);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 35f) <= 0){
            bmiDisplay = getString(R.string.otylosc_I_stopnia);
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 40f) <= 0){
            bmiDisplay = getString(R.string.otylosc_II_stopnia);
        } else {
            bmiDisplay = getString(R.string.otylosc_III_stopnia);
        }

        bmiDisplay = bmi + "\n\n" + bmiDisplay;
        result.setText(bmiDisplay);
    }
}
