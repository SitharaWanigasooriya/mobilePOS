package com.example.sitharawanigasooriy.ma;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Selling extends AppCompatActivity implements SellingInterface {


    private String[] transactionHeader = {"Product Code", "Product Name", "Qty", "Price", "Total"};
    private ArrayList<SellingItem> soldItem = new ArrayList<>();//all the item will add to this


    DynamicTwoDArray transaction = new DynamicTwoDArray();
    private static int no = 1;

    private EditText productCode, quantity, received,discount, tax;
    private TextView subTotal, netTotal, change;
    private Button enter, sellingSearch, sellingBarcode,sellingCash;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);

        ctx = this;

        //Casting the variables
        productCode = (EditText) findViewById(R.id.sellingProductCode);
        quantity = (EditText) findViewById(R.id.sellingQunatity);
        received = (EditText) findViewById(R.id.sellingAmountRecieved);
        discount = (EditText) findViewById(R.id.sellingDiscount);
        tax = (EditText) findViewById(R.id.selling_TaxTxtAmount);
        subTotal = (TextView) findViewById(R.id.selling_Sub_totalTxt);
        netTotal = (TextView) findViewById(R.id.selling_net_total);
        change = (TextView) findViewById(R.id.sellingAmountChange);

        enter = (Button) findViewById(R.id.sellingEnterbutton);
        sellingSearch = (Button) findViewById(R.id.sellingSearch);
        sellingBarcode = (Button) findViewById(R.id.sellingBarcode);
        sellingCash= (Button) findViewById(R.id.selling_cashButton);


        //creating the table
        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.sellingtable);
        tb.setColumnCount(5);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        //Adapters
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, transactionHeader));


        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //when data click this will heppen
                Toast.makeText(Selling.this, ((String[]) clickedData)[1], Toast.LENGTH_LONG).show();
            }
        });


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("myInfoTag", "clicked");

                BackgroundWorker backgroundWorkerSelling = new BackgroundWorker(ctx);
                //this to set delegate/listener back to this class
                backgroundWorkerSelling.delegateSelling = Selling.this;
                if (productCode.getText().toString().equals("") || quantity.getText().toString().equals("") ){
                    Toast.makeText(Selling.this, "Details are not entered", Toast.LENGTH_LONG).show();
                }
                else {
                    backgroundWorkerSelling.execute("sellingItemAccess", productCode.getText().toString(), quantity.getText().toString());
                }

                //looping
                loopingData(soldItem);

                Log.i("myInfoTag", "-----");
                Log.i("myInfoTag", String.valueOf(soldItem.size()));
                Log.i("myInfoTag", "-----");
                //Log.i("myInfoTag", String.valueOf(transaction.toArray().length));
                productCode.setText("");
                quantity.setText("");
                tb.setDataAdapter(new SimpleTableDataAdapter(Selling.this, transaction.toArray()));

            }
        });

        sellingSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSellingSearch = new Intent(ctx, SellingSearch.class);
                startActivity(intentSellingSearch);
            }
        });

        sellingBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBarcode = new Intent(ctx, QRBarcodeScanner.class);
                startActivity(intentBarcode);
            }
        });
        sellingCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float subtotal=0;
                float dis = 0;
                float Taxx = 0;
                Log.i("myInfoTag", String.valueOf(soldItem.size()));
                for(int i =0;i<soldItem.size();i++){
                    soldItem.get(i).setTotal(String.valueOf(Float.parseFloat(soldItem.get(i).getPrice().toString()) * Integer.parseInt(soldItem.get(i).getQuantity().toString())));
                    subtotal+=Float.parseFloat(soldItem.get(i).getTotal().toString());
                    Log.i("myInfoTag", String.valueOf(subtotal));
                }
                subTotal.setText(String.valueOf(subtotal));
                if (discount.getText().toString().equals("") && tax.getText().toString().equals(""))
                {
                    //
                }
                else{
                    dis = subtotal * Float.parseFloat(discount.getText().toString()) / 100;
                    Taxx = subtotal * Integer.parseInt(tax.getText().toString()) / 100;
                }

                float netValue=subtotal-dis+Taxx;
                netTotal.setText(String.valueOf(netValue));
                if(!received.getText().toString().equals("")) {
                    change.setText(String.valueOf(Float.parseFloat(received.getText().toString()) - netValue));
                }
            }
        });


    }


    public void loopingData(ArrayList<SellingItem> array) {
        for (int i = 0; i < array.size(); i++) {
            Log.i("myInfoTag--", String.valueOf(i) + soldItem.get(i).getTotal() + "-------");
            SellingItem item = soldItem.get(i);
            //transaction.add(i,0,Integer.toString(item.getNo())); // 0 --> No
            transaction.add(i, 0, item.getProduct_code().toString());// 1 --> Product code
            transaction.add(i, 1, item.getProduct_name().toString());// 2 --> Product name
            transaction.add(i, 2, item.getQuantity().toString());// 3 --> Quantity
            transaction.add(i, 3, item.getPrice().toString());// 4 --> Price
            transaction.add(i, 4, item.getTotal().toString());// 5 --> Total

        }
    }

    @Override
    public void returnData(String[] detail) {
        int qty = 0;
        //Toast.makeText(Selling.this, "IIIII", Toast.LENGTH_LONG).show();
        SellingItem sellingItem = new SellingItem();

        sellingItem.setNo(no);
        sellingItem.setProduct_code(detail[0]);
        sellingItem.setProduct_name(detail[1]);
        sellingItem.setQuantity(detail[4]);
        sellingItem.setPrice(detail[2]);
        sellingItem.setTotal(String.valueOf(Float.parseFloat(sellingItem.getPrice().toString()) * Integer.parseInt(sellingItem.getQuantity().toString())));


        no++;
        soldItem.add(sellingItem);

    }

    public void calculateSubTotal(){

    }

    public void calculateNetTotal(){

    }

}
