package com.sara.cta07_unitconverterapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.sara.myapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView km, m, cm, mile, yard, foot, inch;

    // Declares TextWatcher to listen for changes in the input EditText
    private TextWatcher inputTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initializes all the UI elements
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);

        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        // The array of the units for the Spinner
        String[] arr = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        // This line initialize the TextWatcher for the input EditText from abouve...
        inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        };


        // adds the TextWatcher to the input EditText
        input.addTextChangedListener(inputTextWatcher);
    }


    // update() - Updates the conversion based on input and selected unit
    private void update() {
        String inputText = input.getText().toString().trim();
        if (!inputText.isEmpty() && !unit.getSelectedItem().toString().isEmpty()) {
            try {
                double in = Double.parseDouble(inputText);
                switch (unit.getSelectedItem().toString()) {
                    case "km":
                        setKm(in);
                        break;
                    case "m":
                        setKm(in / 1000);
                        break;
                    case "cm":
                        setKm(in / 100000);
                        break;
                    case "mm":
                        setKm(in / 1000000);
                        break;
                    case "microm":
                        setKm(in / 1000000000);
                        break;
                    case "nm":
                        double d = 1000000 * 1000000;
                        setKm(in / d);
                        break;
                    case "mile":
                        setKm(in * 1.609);
                        break;
                    case "yard":
                        setKm(in / 1094);
                        break;
                    case "foot":
                        setKm(in / 3281);
                        break;
                    case "inch":
                        setKm(in / 39370);
                        break;
                }
            } catch (NumberFormatException e) {
                input.setError("Please enter a valid number");
            }
        }
    }


    // Method to set the values of the TextViews based on the converted kilometers
    // will be used for the unite test
    private void setKm(double km_in) {
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(ConverterUnit.kmToCm(km_in)));
        cm.setText(String.valueOf(ConverterUnit.kmToCm(km_in)));
        mile.setText(String.valueOf(ConverterUnit.kmToMile(km_in)));
        yard.setText(String.valueOf(ConverterUnit.kmToYard(km_in)));
        foot.setText(String.valueOf(ConverterUnit.kmToFoot(km_in)));
        inch.setText(String.valueOf(ConverterUnit.kmToInch(km_in)));
    }
}
