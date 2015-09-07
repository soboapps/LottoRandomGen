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


public class GenerateRandomPickThree extends Activity {

    Intent intentTh;

    public String p3_1Num;
    public String p3_2Num;
    public String p3_3Num;

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
        setContentView(R.layout.number_combos);

        intentTh = getIntent();

        p3_1Num = intentTh.getStringExtra("p3_1_num");
        p3_2Num = intentTh.getStringExtra("p3_2_num");
        p3_3Num = intentTh.getStringExtra("p3_3_num");

        options = new String[] { p3_1Num, p3_2Num, p3_3Num };

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