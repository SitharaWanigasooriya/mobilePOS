package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashMap;

public class Welcome extends AppCompatActivity {

    private DrawerLayout mDrawerLayOut;
    private ActionBarDrawerToggle mToggle;
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //session class instance
        session = new UserSessionManager(getApplicationContext());

        mDrawerLayOut = (DrawerLayout) findViewById(R.id.welcomedrawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayOut,R.string.open,R.string.close);

        mDrawerLayOut.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(getApplicationContext(),"userlogin status: "+session.isUserLoggedIn(),Toast.LENGTH_LONG).show();


        //If user is not logged in This will redirect user to login activity
        if(session.checkLogin()){
            finish();
        }

        //get user data from session
        HashMap<String,String> user = session.getUserDetails();
        //get name
       // String name = user.get(UserSessionManager.KEY_NAME);
        //get email
        //String email = user.get(UserSessionManager.KEY_EMAIL);
        //Show user data on activity
        //Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        //Toast.makeText(this,email,Toast.LENGTH_LONG).show();
        //lblName.setText(Html.fromHtml("Name:<b>"+name+"</b>"));
        //lblEmail.setText(Html.fromHtml("Email: <b>"+email+"</b>"));


        final NavigationView nav_view = (NavigationView) findViewById(R.id.navigate);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    Intent intentHome = new Intent("com.example.sitharawanigasooriy.ma.Home");
                    startActivity(intentHome);
                }
                else if (id== R.id.myProfile){
                    Intent intentProfile = new Intent("com.example.sitharawanigasooriy.ma.Profile");
                    startActivity(intentProfile);
                }
                else if (id == R.id.info){
                    Intent intentInfo = new Intent("com.example.sitharawanigasooriy.ma.Information");
                    startActivity(intentInfo);
                }
                else if (id == R.id.logOut){
                    session.logoutUser();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
