package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Order extends AppCompatActivity implements View.OnClickListener{

    private CardView placeOrder,viewOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //defining cards
        placeOrder = (CardView) findViewById(R.id.FirstOrderCardView);
        viewOrder = (CardView) findViewById(R.id.SecondOrderCardView);

        //addClickListner to the cards
        placeOrder.setOnClickListener(this);
        viewOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.FirstOrderCardView : i = new Intent(Order.this,PlaceOrder.class); startActivity(i);break;
            case R.id.SecondOrderCardView : i = new Intent(Order.this,ViewOrder.class); startActivity(i);break;

            default:break;
        }
    }
}
