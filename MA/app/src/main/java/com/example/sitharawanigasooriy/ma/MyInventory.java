package com.example.sitharawanigasooriy.ma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyInventory extends AppCompatActivity {


    private EditText productcode,productname,qty;
    private Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_inventory);


        productcode = (EditText)findViewById(R.id.productCodeEditText);
        productname = (EditText)findViewById(R.id.productnameEditText);
        qty = (EditText)findViewById(R.id.quantityEditText);
        Add = (Button)findViewById(R.id.addButton);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("myInfoTag","ssss");
//                if ((username.getText().toString(),companyName.getText().toString(),password.getText().toString(),confirmPassword.getText().toString(),email.getText().toString())){
                    BackgroundWorker backgroundWorkerSignUp = new BackgroundWorker(MyInventory.this);
                    backgroundWorkerSignUp.execute("myInventory", productcode.getText().toString(), productname.getText().toString(),qty.getText().toString());

//                }

            }
        });

    }
}

