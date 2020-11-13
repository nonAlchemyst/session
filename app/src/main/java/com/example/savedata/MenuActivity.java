package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends AppCompatActivity {

    //TextView token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //token = findViewById(R.id.textView2);
        //if (!Global.asGuest)
            //token.setText("token: "+Global.loginData.getToken());
    }

    public void OnClickPhotoRobot(View view){
        Intent intent = new Intent(this, photorobot_activity.class);
        startActivity(intent);
    }

    public void onClickDepartments(View view) {

    }

    public void onClickAboutUs(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void onClickPaint(View view) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }
}