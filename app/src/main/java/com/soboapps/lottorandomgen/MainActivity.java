package com.soboapps.lottorandomgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pick 3 Button
        Button btnPick3 = (Button) findViewById(R.id.buttonPick3);
        btnPick3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText p3_1 = (EditText) findViewById(R.id.editText3_1);
                EditText p3_2 = (EditText) findViewById(R.id.editText3_2);
                EditText p3_3 = (EditText) findViewById(R.id.editText3_3);

                Intent intentTh = new Intent(MainActivity.this, GenerateRandomPickThree.class);
                intentTh.putExtra("p3_1_num", p3_1.getText().toString());
                intentTh.putExtra("p3_2_num", p3_2.getText().toString());
                intentTh.putExtra("p3_3_num", p3_3.getText().toString());
                startActivity(intentTh);
            }
        });

        // Pick 3 Button
        Button btnPick4 = (Button) findViewById(R.id.buttonPick4);
        btnPick4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText p4_1 = (EditText) findViewById(R.id.editText4_1);
                EditText p4_2 = (EditText) findViewById(R.id.editText4_2);
                EditText p4_3 = (EditText) findViewById(R.id.editText4_3);
                EditText p4_4 = (EditText) findViewById(R.id.editText4_4);

                Intent intentFo = new Intent(MainActivity.this, GenerateRandomPickFour.class);
                intentFo.putExtra("p4_1_num", p4_1.getText().toString());
                intentFo.putExtra("p4_2_num", p4_2.getText().toString());
                intentFo.putExtra("p4_3_num", p4_3.getText().toString());
                intentFo.putExtra("p4_4_num", p4_4.getText().toString());
                startActivity(intentFo);
            }
        });

        // Pick 3 Button
        Button btnPick5 = (Button) findViewById(R.id.buttonPick5);
        btnPick5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText p5_1 = (EditText) findViewById(R.id.editText5_1);
                EditText p5_2 = (EditText) findViewById(R.id.editText5_2);
                EditText p5_3 = (EditText) findViewById(R.id.editText5_3);
                EditText p5_4 = (EditText) findViewById(R.id.editText5_4);
                EditText p5_5 = (EditText) findViewById(R.id.editText5_5);

                Intent intentFi = new Intent(MainActivity.this, GenerateRandomPickFive.class);
                intentFi.putExtra("p5_1_num", p5_1.getText().toString());
                intentFi.putExtra("p5_2_num", p5_2.getText().toString());
                intentFi.putExtra("p5_3_num", p5_3.getText().toString());
                intentFi.putExtra("p5_4_num", p5_4.getText().toString());
                intentFi.putExtra("p5_5_num", p5_5.getText().toString());
                startActivity(intentFi);
            }
        });

    }


}