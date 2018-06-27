package com.example.sitharawanigasooriy.ma;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Sithara wanigasooriy on 5/6/2018.
 */

public class UserSessionManager {

    //Shared preferences reference
    SharedPreferences pref;
    //Editor reference foer shared preferences
    SharedPreferences.Editor editor;
    //Context
    Context _context;

    //Shared preference mode
    int PRIVATE_MODE = 0;

    //Shared preference file name
    private static final String PREFER_NAME = "AndroidExamplePref";

    //All shared preferences keys
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    //User name (make variable public to access from outside)
    private static final String KEY_NAME = "name";

    //Email address (make variable public to access from outside)
    private static final String KEY_EMAIL = "email";

    //Constructor
    public UserSessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }

    //Create login session
    public void createUserLoginSession(String name,String email){
        //Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN,true);

        //Storing name in pref
        editor.putString(KEY_NAME,name);

        //Storing email in pref
        editor.putString(KEY_EMAIL,email);

        //commit changes
        editor.commit();

    }
    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_USER_LOGIN,false);
    }

    /*
    *Check login method will check user login status
    * if false it will redirect user to login page
    * else do anything
    * */
    public boolean checkLogin(){
        //Check login status
        if(!this.isUserLoggedIn()){

            //user is not logged in redirect him in to login activity
            Intent i = new Intent(_context,Login.class);

            //Closing all the activities from statck
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Add new flag to start new activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //starting login Activity
            _context.startActivity(i);
            return true;
        }
        return false;
    }
    /*
    *Get stored Session data
     */

    public HashMap<String,String> getUserDetails(){
        //Use hashmap to store user credentials
        HashMap<String,String> user = new HashMap<String,String>();

        //username
        user.put(KEY_NAME,pref.getString(KEY_NAME,null));

        //user email id
        user.put(KEY_EMAIL,pref.getString(KEY_EMAIL,null));

        return user;
    }

    /**
    *Clear session details
    */

    public void logoutUser(){
        //Clearing all user data from Shat=red preferences
        editor.clear();
        editor.commit();

        //After logout redirect user login activity
        Intent i = new Intent(_context,Login.class);

        //Closing all the activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Add new flag to start new activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //Starting login activity
        _context.startActivity(i);
    }


}
