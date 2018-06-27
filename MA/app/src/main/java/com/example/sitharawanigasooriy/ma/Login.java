package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    EditText usernameEdt, passwordEdt;
    //protected CheckBox rememberMe;
    // protected TextView forgetPassword;
    Button loginButton;
    // int attemptCounter = 5;

    UserSessionManager session;


    public Login() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //User session manager
        session = new UserSessionManager(getApplicationContext());


        usernameEdt = (EditText) findViewById(R.id.usernameLoginEdittxt);
        passwordEdt = (EditText) findViewById(R.id.passwordLoginEditTxtView);
        //rememberMe = (CheckBox)findViewById(R.id.checkBoxlogin);
        //forgetPassword = (TextView)findViewById(R.id.fogetpasswordLoginTextView);

        Toast.makeText(getApplicationContext(),"User Login Status: "+session.isUserLoggedIn(),Toast.LENGTH_LONG).show();
        loginButton = (Button) findViewById(R.id.buttonLogin);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr = usernameEdt.getText().toString();
                String passstr = passwordEdt.getText().toString();
                String type = "login";
                Toast.makeText(Login.this, "thisss"+namestr+passstr, Toast.LENGTH_LONG).show();
                OnLogin(type,namestr,passstr);


            }
        });

    }

    //run background workers
    public void OnLogin(String typ,String nastr,String passtr) {

        if (nastr.trim().equals("") || passtr.trim().equals("")){
            Toast.makeText(Login.this, "Please enter all the required fields", Toast.LENGTH_LONG).show();
            Intent intentReturn = new Intent(Login.this,Login.class); startActivity(intentReturn);
        }
        else{

            session.createUserLoginSession("","");
                Intent intentWelcome = new Intent(this,Welcome.class);
                this.startActivity(intentWelcome);
//            BackgroundWorker backgroundWorkerLogin = new BackgroundWorker(this);
//            backgroundWorkerLogin.execute(typ, nastr, passtr);



        }
    }
}
