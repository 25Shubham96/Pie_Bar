package com.example.shubhammundra.pie_bar;

/*import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class PieChart extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        pieChart = findViewById(R.id.pc_mypiechart);

        Intent i = new Intent();

        ArrayList<String> qwerty = (ArrayList<String>) i.getSerializableExtra("Labels");

        ArrayList<Entry> MYpieEntry = new ArrayList<>();

        MYpieEntry.add(new Entry(10f,0));
        MYpieEntry.add(new Entry(15f,0));
        MYpieEntry.add(new Entry(20f,0));
        MYpieEntry.add(new Entry(25f,0));
        MYpieEntry.add(new Entry(30f,0));
        MYpieEntry.add(new Entry(35f,0));
        MYpieEntry.add(new Entry(40f,0));

        PieDataSet pieDataSet = new PieDataSet(MYpieEntry,"General Display");
        int[] MyColor = {Color.parseColor("#D32F2F"),
                Color.parseColor("#C2185B"),
                Color.parseColor("#7B1FA2"),
                Color.parseColor("#512DA8"),
                Color.parseColor("#303F9F"),
                Color.parseColor("#1976D2"),
                Color.parseColor("#0288D1"),
                Color.parseColor("#0097A7"),
                Color.parseColor("#00796B"),
                Color.parseColor("#388E3C"),
                Color.parseColor("#689F38"),
                Color.parseColor("#AFB42B"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FFA000"),
                Color.parseColor("#F57C00"),
                Color.parseColor("#E64A19"),
                Color.parseColor("#5D4037"),
                Color.parseColor("#616161"),
                Color.parseColor("#455A64")};

        pieDataSet.setColors(MyColor);

        PieData pieData = new PieData(qwerty,pieDataSet);

        pieChart.setData(pieData);
    }
}
*/