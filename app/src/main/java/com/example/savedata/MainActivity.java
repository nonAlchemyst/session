package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText login ;
    EditText pass ;
    Button button ;
    CheckBox check ;
    static final String APP_PREFERENCE = "mysettings";
    static final String APP_PREFERENCE_Login = "login";
    static final String APP_PREFERENCE_Password = "Password";
    SharedPreferences mSettings;
    int wronglogin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.loginedit);
        pass = findViewById(R.id.passedit);
        button = findViewById(R.id.buttonclick);
        check = findViewById(R.id.checkBox);
        mSettings = getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
        if(mSettings.contains(APP_PREFERENCE_Login)) {
            login.setText(mSettings.getString(APP_PREFERENCE_Login, ""));
            pass.setText(mSettings.getString(APP_PREFERENCE_Password, ""));
            check.setChecked(true);
        }
       // ArrayAdapter<String> = new ArrayAdapter<String>(this, );
    }

    public void buttonClick(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mad2019.hakta.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Otpravka service = retrofit.create(Otpravka.class);
        Call<LoginResponse> response = service.getLogin(login.getText().toString(),pass.getText().toString());
        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.code() == 200) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    if (check.isChecked()) {
                        editor.putString(APP_PREFERENCE_Login, login.getText().toString());
                        editor.putString(APP_PREFERENCE_Password, pass.getText().toString());
                        editor.apply();
                    } else {
                        editor.clear();
                        editor.apply();
                    }
                    Global.loginData = response.body().getData();
                    Global.asGuest = false;
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    //intent.putExtra("token", response.body().getData().getToken());
                    //intent.putExtra("asGuest", false);
                    startActivity(intent);
                }
                else{
                    if(wronglogin >= 3){
                        Intent intent = new Intent(MainActivity.this, MainActivityWithCaptcha.class);
                        startActivity(intent);
                    }
                    wronglogin += 1;
                    Toast.makeText(MainActivity.this,"Неверный логин или пароль",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Ошибка подключения",Toast.LENGTH_LONG).show();
            }
        });


    }
    public void asGuest(View v){
        Global.asGuest = true;
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        //intent.putExtra("asGuest", false);
        Toast.makeText(MainActivity.this,"Как гость",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

}