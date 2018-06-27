package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlaceOrder extends AppCompatActivity {

    EditText productCode,Qty,customer;
    Button placeOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        productCode = (EditText) findViewById(R.id.placeOrderProductCodeEditText);
        Qty = (EditText) findViewById(R.id.placeOrderQtyEditText);
        customer = (EditText) findViewById(R.id.placeOrderCustomerEditText);

        placeOrder = (Button) findViewById(R.id.placeOrdeerButton);

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("myTag","button");
                String code = productCode.getText().toString();
                String quantity = Qty.getText().toString();
                String cust = customer.getText().toString();
                String type = "placeOrder";
                //Toast.makeText(Login.this, "thisss"+namestr+passstr, Toast.LENGTH_LONG).show();
                order(type,code,quantity,cust);


            }
        });
    }
    public void order(String typ,String codee,String quantityy, String customer) {

        if (codee.trim().equals("") || quantityy.trim().equals("")){
            Toast.makeText(PlaceOrder.this, "Please enter all the required fields", Toast.LENGTH_LONG).show();
            Intent intentReturn = new Intent(PlaceOrder.this,Login.class); startActivity(intentReturn);
        }
        else{

            BackgroundWorker backgroundWorkerPlaceOrder = new BackgroundWorker(this);
            backgroundWorkerPlaceOrder.execute(typ, codee, quantityy,customer);
        }
    }
}
