package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CaloriesActivity extends AppCompatActivity {

    Button calculate;
    EditText height;
    EditText weight;
    EditText age;
    TextView result;
    Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        height = findViewById(R.id.heightCalories);
        weight = findViewById(R.id.weightCalories);
        age = findViewById(R.id.ageCalories);
        genderSpinner = findViewById(R.id.genderSpinner);
        result = findViewById(R.id.resultCalories);
        calculate = findViewById(R.id.calculateCalories);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (age.getText().length() > 0
                        && weight.getText().length() > 0
                        && height.getText().length() > 0) {
                    calculateCalories();
                } else {
                    Toast.makeText(CaloriesActivity.this, "Uzupełnij wszystkie dane", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void calculateCalories() {
        double res = 0;
        switch (genderSpinner.getSelectedItem().toString()) {
            case "Mężczyzna":
                res = calcForMale();
                break;
            case "Kobieta":
                res = calcForFemale();
                break;
            default:
                break;
        }
        result.setText(String.valueOf(res));
    }

    double calcForMale() {
        return 66.5 + (13.75 * Double.parseDouble(weight.getText().toString()))
                + (5.003 * Double.parseDouble(height.getText().toString()))
                - (6.775 * Double.parseDouble(age.getText().toString()));
    }

    double calcForFemale() {
        return 655.1 + (9.563 * Double.parseDouble(weight.getText().toString()))
                + (1.85 * Double.parseDouble(height.getText().toString()))
                - (4.676 * Double.parseDouble(age.getText().toString()));
    }
}
