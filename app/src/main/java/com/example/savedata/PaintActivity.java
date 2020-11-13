package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.savedata.R;

//import com.example.savedata.DrawView;

public class PaintActivity extends Activity{

    DrawView drawView ;
    CardView palettecard ;
    LinearLayout linearLayout ;
    Spinner spinner ;
    boolean choiseColorFlag = false;

    Integer[] strokeWidth = {10, 15, 20, 50, 100};
    String[] stroke = {"Ширина 10 ","Ширина 15 ","Ширина 20 ","Ширина 50 ","Ширина 100 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        drawView = new DrawView(this, null);
        drawView = findViewById(R.id.drawing);
        palettecard =findViewById(R.id.palettecard);
        linearLayout = findViewById(R.id.colorlist);
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stroke);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                drawView.setStrokeWidth(strokeWidth[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClickLastik(View v){
        drawView.Lastik();
    }

    public void onClickResetColor(View v){
        drawView.prevColor();
    }

    public void onPaletteClick(View v){
        if (choiseColorFlag){
            palettecard.setVisibility(View.GONE);
            choiseColorFlag = false;
            return;
        }
        choiseColorFlag = true;
        palettecard.setVisibility(View.VISIBLE);
    }

    public void choiseColor(View view){
        ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();
        drawView.changeColor(colorDrawable.getColor());
        palettecard.setVisibility(View.GONE);
        choiseColorFlag = false;
    }
}