package com.example.sitharawanigasooriy.ma;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sithara wanigasooriy on 4/3/2018.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    AlertDialog alertDialog1;
    ProgressDialog progressDialog;

    public SellingInterface delegateSelling = null;
    public InventoryInterface delegateInventory=null;
    ArrayList<ArrayList<String>> dataArray =new ArrayList();
    ArrayList<ArrayList<String>> orderDataArray =new ArrayList();
    //public BackgroundWorker(Context ctx){context =ctx;progressDialog = new ProgressDialog(ctx);}


    public BackgroundWorker(Context context){
        //this.delegate = delegate;
        this.context=context;
        progressDialog = new ProgressDialog(context);
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        if(type.equals("login")){
            String login_url = "https://app-1526470973.000webhostapp.com/login.php";
            Log.i("myInfoTag","inMain");
            try {
                String username = params[1];
                String password = params[2];


                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.i("myInfoTag","connection");

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                Log.i("myInfoTag","writting");
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("signUp")){
            String login_url = "https://app-1526470973.000webhostapp.com/signUp.php";
            try {
                String userName = params[1];
                String companyName = params[2];
                String password = params[3];
                String email = params[4];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("userName","UTF-8")+"="+URLEncoder.encode(userName,"UTF-8")+"&"
                        +URLEncoder.encode("companyName","UTF-8")+"="+URLEncoder.encode(companyName,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("sellingItemAccess")){
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/sellingItemAccess.php";
            try {
                String code = params[1];
                String qty = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(code,"UTF-8")+"&"
                        +URLEncoder.encode("qty","UTF-8")+"="+URLEncoder.encode(qty,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("inventoryAccess")){
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/inventoryAccess.php";
            try {

                String tableName = params[1];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("tableName","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("placeOrder")){
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/placeOrders.php";
            Log.i("myInfoTag","inMain");
            try {
                String code = params[1];
                String qty = params[2];
                String customer = params[3];


                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.i("myInfoTag","connection");

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(code,"UTF-8")+"&"
                        +URLEncoder.encode("qty","UTF-8")+"="+URLEncoder.encode(qty,"UTF-8")+"&"
                        +URLEncoder.encode("customer","UTF-8")+"="+URLEncoder.encode(customer,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                Log.i("myInfoTag","writting");
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(type.equals("viewOrder")){
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/viewOrders.php";
            Log.i("myInfoTag","inMain");
            try {
                String tableName = params[1];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.i("myInfoTag","connection");

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("tableName","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                Log.i("myInfoTag","writting");
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(type.equals("billAccess")){
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/billAccess.php";
            Log.i("myInfoTag","inMain");
            try {
                String tableName = params[1];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.i("myInfoTag","connection");

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("tableName","UTF-8")+"="+URLEncoder.encode(tableName,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                Log.i("myInfoTag","writting");
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result = "";
                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(type.equals("myInventory")) {
            String login_url = "https://sitharawanigasooriya.000webhostapp.com/myInventory.php";
            Log.i("myInfoTag", "inMain");
            try {
                String productCode = params[1];
                String productName = params[2];
                String quan =params[3];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                Log.i("myInfoTag", "connection");

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //Data URL
                String post_data = URLEncoder.encode("productCode", "UTF-8") + "=" + URLEncoder.encode(productCode, "UTF-8")+"&"
                        +URLEncoder.encode("productName","UTF-8")+"="+URLEncoder.encode(productName,"UTF-8")+"&"
                        +URLEncoder.encode("quan","UTF-8")+"="+URLEncoder.encode(quan,"UTF-8");
                //Write post data in to buffered writer
                bufferedWriter.write(post_data);
                Log.i("myInfoTag", "writting");
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog1 = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("myInfoTag","onPostExecute");
        String trimResult=result.trim();
        alertDialog.setMessage(trimResult);
        alertDialog.show();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                alertDialog.dismiss();
                //alertDialog1.dismiss();
                timer.cancel(); //this will cancel the timer of the system
            }
        }, 5000);

        // can sent the type with the result. Append the type end of the result with a known symbol
        //regarding login activity
        if(trimResult.equals("login success")){
            Intent intentWelcome = new Intent(context,Welcome.class);

            //intentWelcome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intentWelcome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentWelcome);
        }
        else if (trimResult.equals("login not success")){
            Intent intentLogin = new Intent(context,Login.class);
            context.startActivity(intentLogin);
        }
        //regarding signUp activity
        else if (trimResult.equals("Sign up Successfuly!")){
            Intent intentLogin = new Intent(context,Login.class);
            context.startActivity(intentLogin);
        }
        else if (trimResult.equals("Not Registered!!")){
            Intent intentLogin = new Intent(context,Login.class);
            context.startActivity(intentLogin);
        }
        /*else if(result.trim().contains(",")){
            Toast.makeText(context,"retrived"+Selling.sortOutData(result.trim())[0],Toast.LENGTH_LONG).show();
        }*/

        /*
         * Access the main inventory
         * details[0]=product_code
         * details[1]=product_name
         * details[2]=price
         * details[3]=discount
         * details[4]=quantity in main inventory
         * details[5]=quantity in current
         */
        else if(trimResult.substring(0, Math.min(trimResult.length(), 4)).equals("Sell" ) && trimResult.length()>4 ){//Reading the first 4 characters
            String[] detailedData = trimResult.substring(4, trimResult.length()).split(",");
            delegateSelling.returnData(detailedData);
            Log.i("myInfoTag", detailedData[0]+detailedData[1]+detailedData[2]+detailedData[3]);
        }

        else if(trimResult.substring(0, Math.min(trimResult.length(), 4)).equals("inve" ) && trimResult.length()>4 ) {//Reading the first 4 characters
            Log.i("myInfoTag", "in");
            String withFrontAndEndComa = (trimResult.substring(4, trimResult.length()));
            String withMiddleComa = withFrontAndEndComa.substring(1, withFrontAndEndComa.length() - 1);
            String[] detailedData = withMiddleComa.split(",");
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 1; i < detailedData.length + 1; i++) {
                if (i % 4 != 0) {
                    temp.add(detailedData[i - 1]);
                } else {
                    temp.add(detailedData[i - 1]);
                    dataArray.add(temp);
                    temp = new ArrayList<>();
                }
            }
            Log.i("myInfoTag", String.valueOf(dataArray.size()));
            delegateInventory.returnData(dataArray);
        }
        else if(trimResult.substring(0, Math.min(trimResult.length(), 4)).equals("orde" ) && trimResult.length()>4 ) {//Reading the first 4 characters
            Log.i("myInfoTag", "in");
            String withFrontAndEndComa = (trimResult.substring(4, trimResult.length()));
            String withMiddleComa = withFrontAndEndComa.substring(1, withFrontAndEndComa.length() - 1);
            String[] detailedData = withMiddleComa.split(",");
            ArrayList<String> temp = new ArrayList<>();

            for (int i = 1; i < detailedData.length + 1; i++) {

                if (i % 3 != 0) {
                    temp.add(detailedData[i-1]);
                } else {
                    temp.add(detailedData[i-1]);
                    orderDataArray.add(temp);
                    temp = new ArrayList<>();
                }
            }

            delegateInventory.returnData(orderDataArray);
        }
        else{
            Log.i("myInfoTag",trimResult);

        }
        progressDialog.hide();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
