package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class photorobot_activity extends AppCompatActivity {

    ImageView iTop ;
    ImageView iMiddle ;
    ImageView iBottom ;
    List<Integer> topImage = new ArrayList<Integer>();
    List<Integer> middleImage = new ArrayList<Integer>();
    List<Integer> bottomImage = new ArrayList<Integer>();
    int top = 0;
    int middle = 0;
    int bottom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photorobot_activity);
        iTop = findViewById(R.id.imagetop);
        iMiddle = findViewById(R.id.imagemiddle);
        iBottom = findViewById(R.id.imagebottom);

        topImage.add(R.drawable.cooltop);
        topImage.add(R.drawable.crying3top);
        topImage.add(R.drawable.father1top);

        middleImage.add(R.drawable.cool1middle);
        middleImage.add(R.drawable.crying3middle);
        middleImage.add(R.drawable.father1middle);

        bottomImage.add(R.drawable.cool1bottom);
        bottomImage.add(R.drawable.crying3bottom);
        bottomImage.add(R.drawable.father1bottom);

        iTop.setImageResource(topImage.get(top));
        iMiddle.setImageResource(middleImage.get(middle));
        iBottom.setImageResource(bottomImage.get(bottom));

    }

    public void onClickButtonTop1(View v){
        top += 1;
        if(top == topImage.size())
            top = 0;
        iTop.setImageResource(topImage.get(top));
    }
    public void onClickButtonTop2(View v){
        top -= 1;
        if(top == -1)
            top = topImage.size()-1;
        iTop.setImageResource(topImage.get(top));
    }

    public void onClickButtonMiddle1(View v){
        middle += 1;
        if(middle == middleImage.size())
            middle = 0;
        iMiddle.setImageResource(middleImage.get(middle));
    }
    public void onClickButtonMiddle2(View v){
        middle -= 1;
        if(middle == -1)
            middle = middleImage.size()-1;
        iMiddle.setImageResource(middleImage.get(middle));
    }

    public void onClickButtonBottom1(View v){
        bottom += 1;
        if(bottom == bottomImage.size())
            bottom = 0;
        iBottom.setImageResource(bottomImage.get(bottom));
    }
    public void onClickButtonBottom2(View v){
        bottom -= 1;
        if(bottom == -1)
            bottom = bottomImage.size()-1;
        iBottom.setImageResource(bottomImage.get(bottom));
    }

}