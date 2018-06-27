package com.example.sitharawanigasooriy.ma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText username,companyName,email,password,confirmPassword;
    private  Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SignupButton(this);
    }

    public void SignupButton(final Context ctx){
        username = (EditText)findViewById(R.id.signupUsernameEditText);
        companyName = (EditText)findViewById(R.id.signupCompanynameEditText);
        email = (EditText)findViewById(R.id.signupEmailEditText);
        password = (EditText)findViewById(R.id.signupPasswordEditText);
        confirmPassword = (EditText)findViewById(R.id.signupConfirmPasswordEditText);
        signUp = (Button)findViewById(R.id.signupButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(username.getText().toString(),companyName.getText().toString(),password.getText().toString(),confirmPassword.getText().toString(),email.getText().toString())){
                    BackgroundWorker backgroundWorkerSignUp = new BackgroundWorker(ctx);
                    backgroundWorkerSignUp.execute("signUp", username.getText().toString(), companyName.getText().toString(),password.getText().toString(),email.getText().toString());

                }

            }
        });

    }



    public boolean validate(String name,String Company,String pass,String ConPass,String email ){

        if (name.length()<3){
            //should check the user name is in the db or not
            Toast.makeText(SignUp.this,"Please Enter a name that long than 3 characters",Toast.LENGTH_LONG).show();
            Intent intentSignIn = new Intent("com.example.sitharawanigasooriy.ma.SignUp");startActivity(intentSignIn);
            return false;
        }
        else if(Company.length()<2){
            //should check the company name is in the db or not
            Toast.makeText(SignUp.this,"Please Enter a company name that long than 3 characters",Toast.LENGTH_LONG).show();
            Intent intentSignIn = new Intent("com.example.sitharawanigasooriy.ma.SignUp");startActivity(intentSignIn);
            return false;
        }
        else if (!pass.equals(ConPass)) {
            Toast.makeText(SignUp.this, "Please check your password", Toast.LENGTH_LONG).show();
            Intent intentSignIn = new Intent("com.example.sitharawanigasooriy.ma.SignUp");startActivity(intentSignIn);
            return false;
        }
        else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            Toast.makeText(SignUp.this, "email is not valid", Toast.LENGTH_LONG).show();
            Intent intentSignIn = new Intent("com.example.sitharawanigasooriy.ma.SignUp");startActivity(intentSignIn);

            return false;
        }
        else{
            return true;
        }
    }
}
