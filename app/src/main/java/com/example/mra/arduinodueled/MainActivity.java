package com.example.mra.arduinodueled;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AbstractAdkActivity  {

    TextView textIn;
    RadioButton ledOn, ledOff;

    @Override
    protected void doOnCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        textIn = (TextView)findViewById(R.id.textin);
        ledOn = (RadioButton)findViewById(R.id.LedOn);
        ledOff = (RadioButton)findViewById(R.id.LedOff);

        ledOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){
                    WriteAdk("LEDON");
                    Toast.makeText(getApplicationContext(),
                            "LEDON", Toast.LENGTH_LONG).show();
                }
            }});

        ledOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){
                    WriteAdk("LEDOFF");
                    Toast.makeText(getApplicationContext(),
                            "LEDOFF", Toast.LENGTH_SHORT).show();
                }
            }});

    }

    @Override
    protected void doAdkRead(String stringIn) {
        textIn.setText(stringIn);
    }
}
