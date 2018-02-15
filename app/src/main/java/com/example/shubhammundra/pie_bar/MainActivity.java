package com.example.shubhammundra.pie_bar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.logging.Formatter;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {

    Button pie;

    BarChart barChart;

    TextView textView;

    com.github.mikephil.charting.charts.BarChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pie = findViewById(R.id.btn_pie);
        barChart = findViewById(R.id.bc_view);
        textView = findViewById(R.id.tv_ipaddr);

        @SuppressLint("WifiManagerLeak")
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = String.format("%d.%d.%d.%d",(ipAddress & 0xff), (ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));

        textView.setText(ip.trim());

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(-4f, 0));
        entries.add(new BarEntry(-20f, 1));
        entries.add(new BarEntry(-6f, 2));
        entries.add(new BarEntry(-8f, 3));
        entries.add(new BarEntry(-18f, 4));
        entries.add(new BarEntry(0E-20f, 5));

        BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(labels, dataset);

        barChart.setData(data);

        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewPieChart.class);
                intent.putExtra("Labels",labels);
                startActivity(intent);
            }
        });
    }
}

class NewPieChart extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        pieChart = findViewById(R.id.bc_view);

        Intent i = getIntent();

        ArrayList<String> qwerty = (ArrayList<String>) i.getSerializableExtra("Labels");

        ArrayList<BarEntry> MYpieEntry = new ArrayList<>();

        MYpieEntry.add(new BarEntry(10f,0));
        MYpieEntry.add(new BarEntry(15f,0));
        MYpieEntry.add(new BarEntry(20f,0));
        MYpieEntry.add(new BarEntry(25f,0));
        MYpieEntry.add(new BarEntry(30f,0));
        MYpieEntry.add(new BarEntry(35f,0));

        BarDataSet pieDataSet = new BarDataSet(MYpieEntry,"General Display");
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

        BarData pieData = new BarData(qwerty,pieDataSet);

        pieChart.setData(pieData);
    }
}