package com.soboapps.lottorandomgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerateRandomPickFour extends Activity {

    Intent intentFo;

    public String p4_1Num;
    public String p4_2Num;
    public String p4_3Num;
    public String p4_4Num;

    public String[] options;
    public String[] genNumbers;

    public ListAdapter simpleAdpt;
    public List<Map<String, String>> numberList = new ArrayList<Map<String,String>>();

    public void sequence(int level, String[] holder) {

        if (level >= options.length) {
            numberList.add(createNumbers("numbers", Arrays.toString(holder)));
            return;
        }

        String val = options[level];
        String[] inrHolder = null;
        for (int c = 0; c < holder.length; c++) {
            inrHolder = holder.clone();
            if (inrHolder[c] == null) {
                inrHolder[c] = val;
                sequence(level + 1, inrHolder.clone());
            }
        }
        return;
    }

    //@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickthree);

        intentFo = getIntent();

        p4_1Num = intentFo.getStringExtra("p4_1_num");
        p4_2Num = intentFo.getStringExtra("p4_2_num");
        p4_3Num = intentFo.getStringExtra("p4_3_num");
        p4_4Num = intentFo.getStringExtra("p4_4_num");

        options = new String[] { p4_1Num, p4_2Num, p4_3Num, p4_4Num };
        genNumbers = new String[options.length];

        sequence(0, genNumbers.clone());

        ListView lv = (ListView) findViewById(R.id.listView);
        simpleAdpt = new SimpleAdapter(this, numberList, android.R.layout.simple_list_item_1, new String[] {"numbers"}, new int[] {android.R.id.text1});

        lv.setAdapter(simpleAdpt);
    }

    public HashMap<String, String> createNumbers(String key, String name) {
        HashMap<String, String> numbers = new HashMap<String, String>();
        numbers.put(key, name);

        return numbers;
    }
}