package com.example.sitharawanigasooriy.ma;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class ViewOrder extends AppCompatActivity implements InventoryInterface{
    private String[] viewOrderHeader = {"Product Code", "Qty", "Customer"};
    private ArrayList<Item> orderdItem = new ArrayList();
    public ArrayList<String[][]> dataOrderArray = new ArrayList<>();
    //public TableView<String[]> tb;
    DynamicTwoDArray orderData = new DynamicTwoDArray();
    private Button viewOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        viewOrder = (Button) findViewById(R.id.viewOrder);
        //creating the table
        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.viewOrdertable);

        tb.setColumnCount(3);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        ///Adapters
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, viewOrderHeader));


        //tb.SetColumnWeight(0, 2);
        populateData();

        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //when data click this will heppen
                Toast.makeText(ViewOrder.this,((String[])clickedData)[1],Toast.LENGTH_LONG).show();
            }
        });

        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(String[][] i : dataOrderArray) {
                    Log.i("myInfoTag", "+++"+dataOrderArray.size());
                    tb.setDataAdapter(new SimpleTableDataAdapter(ViewOrder.this, i));

                }

            }
        });
    }

    public void populateData(){
        BackgroundWorker backgroundWorkerViewOrder = new BackgroundWorker(this);
        backgroundWorkerViewOrder.delegateInventory= ViewOrder.this;
        backgroundWorkerViewOrder.execute("viewOrder","orderr");
    }

    @Override
    public void returnData(ArrayList<ArrayList<String>> onPostData) {

        for(int j=0;j<onPostData.size();j++) {

            Log.i("myInfoTag--", j + "-------");
            orderData.add(j, 0, onPostData.get(j).get(0).toString());// 0-->code
            orderData.add(j, 1, onPostData.get(j).get(1).toString());// 2 --> qty
            orderData.add(j, 2, onPostData.get(j).get(2).toString());// 3 --> customer
            dataOrderArray.add(orderData.toArray());

            //setting up the object
//            item.setProduct_code(onPostData.get(j).get(0).toString());
//            item.setProduct_name(onPostData.get(j).get(1).toString());
//            item.setPrice(onPostData.get(j).get(2).toString());
//            item.setQuantity(onPostData.get(j).get(3).toString());
//            orderdItem.add(item);

        }
    }
}

