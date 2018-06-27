package com.example.sitharawanigasooriy.ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener{

    private CardView chooseProduct,viewInventory,viewMyPath,viewHistory,addOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //defining cards
        chooseProduct = (CardView) findViewById(R.id.FirstHomeCardView);
        viewInventory = (CardView) findViewById(R.id.SecondHomeCardView);
        viewMyPath = (CardView) findViewById(R.id.ThirdHomeCardView);
        viewHistory = (CardView) findViewById(R.id.ForthHomeCardView);
        addOrder = (CardView) findViewById(R.id.FifthHomeCardView);

        //addClickListner to the cards
        chooseProduct.setOnClickListener(this);
        viewInventory.setOnClickListener(this);
        viewMyPath.setOnClickListener(this);
        viewHistory.setOnClickListener(this);
        addOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.FirstHomeCardView : i = new Intent(Home.this,Selling.class); startActivity(i);break;
            case R.id.SecondHomeCardView : i = new Intent(Home.this,Inventory.class); startActivity(i);break;
            case R.id.ThirdHomeCardView: i = new Intent(Home.this,MyInventory.class); startActivity(i);break;
            case R.id.ForthHomeCardView: i = new Intent(Home.this,History.class); startActivity(i);break;
            case R.id.FifthHomeCardView: i = new Intent(Home.this,Order.class); startActivity(i);break;
            default:break;
        }
    }
}
