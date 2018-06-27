package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {
    private static Button buttonLogin;
    private static Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        OnClickButtonListener();
    }

    public void OnClickButtonListener(){
        buttonLogin = (Button)findViewById(R.id.FirstPageLOGINButton);
        buttonSignUp = (Button)findViewById(R.id.FirstpageSIGNUPButton);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent("com.example.sitharawanigasooriy.ma.Login");
                startActivity(intentLogin);
//                Intent intentLogin = new Intent("com.example.sitharawanigasooriy.ma.Welcome");
//                startActivity(intentLogin);
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignup = new Intent("com.example.sitharawanigasooriy.ma.SignUp");
                startActivity(intentSignup);
            }
        });
    }
}
