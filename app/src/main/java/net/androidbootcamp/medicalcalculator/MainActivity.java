package net.androidbootcamp.medicalcalculator;

import android.icu.text.DecimalFormat;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

//Elliott Britton 1/17/2017
public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton)findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = (RadioButton)findViewById(R.id.radKiloToLb);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered=Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                if(lbToKilo.isChecked()) {
                    if (weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " kilograms");
                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
