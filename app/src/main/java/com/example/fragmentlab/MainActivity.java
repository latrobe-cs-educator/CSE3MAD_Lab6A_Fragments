package com.example.fragmentlab;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    Button resButton = null;
    EditText opA = null;
    EditText opB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resButton = (Button) findViewById(R.id.button);
        opA = (EditText) findViewById(R.id.firstOperandET);
        opB = (EditText) findViewById(R.id.secondOperandET);

        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentA fA = (FragmentA)
                        getSupportFragmentManager().findFragmentById(R.id.fragmentA);
                FragmentB fB = (FragmentB)
                       getSupportFragmentManager().findFragmentById(R.id.fragmentB);
                int a = Integer.parseInt(opA.getText().toString());
                int b = Integer.parseInt(opB.getText().toString());
                if(a !=0 && b!=0) {
                    fA.doCalcDisplay(a, b);
                    fB.doCalcDisplay(a, b);
                } else {
                    Toast.makeText(getApplicationContext(),"Please enter non-zero integers", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}