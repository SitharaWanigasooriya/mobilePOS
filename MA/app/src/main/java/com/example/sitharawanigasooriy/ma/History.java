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

public class History extends AppCompatActivity implements InventoryInterface{

    private String[] historyHeader = {"Bill no", "Date-Time", "Amount"};//for further details use clicking the method
    DynamicTwoDArray historyData = new DynamicTwoDArray();
    private ArrayList<Item> historyLog = new ArrayList();
    ArrayList<String[][]> dataBillArray = new ArrayList<>();

    private Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        history = (Button) findViewById(R.id.History);

        //creating the table
        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.historytable);
        //var tb = FindViewById<TableView>(Resource.Id.inventorytable);

        tb.setColumnCount(3);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        //Adapters
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, historyHeader));

        //tb.SetColumnWeight(0, 2);
        populateData();

        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //when data click this will heppen
                Toast.makeText(History.this,((String[])clickedData)[1],Toast.LENGTH_LONG).show();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(String[][] i : dataBillArray) {
                    Log.i("myInfoTag", "+++");
                    tb.setDataAdapter(new SimpleTableDataAdapter(History.this, i));

                }

            }
        });
    }

    public void populateData(){
        BackgroundWorker backgroundWorkerHistory = new BackgroundWorker(this);
        backgroundWorkerHistory.delegateInventory= History.this;
        backgroundWorkerHistory.execute("billAccess","bill");
    }

    @Override
    public void returnData(ArrayList<ArrayList<String>> onPostData) {
        for(int j=0;j<onPostData.size();j++) {

            Item item = new Item();
            Log.i("myInfoTag--", j + "-------");
            historyData.add(j, 0, onPostData.get(j).get(0).toString());// 0-->bill no
            historyData.add(j, 1, onPostData.get(j).get(1).toString());// 2 --> date-time
            historyData.add(j, 2, onPostData.get(j).get(2).toString());// 3 --> amount
            dataBillArray.add(historyData.toArray());

            //setting up the object
//            item.setProduct_code(onPostData.get(j).get(0).toString());
//            item.setProduct_name(onPostData.get(j).get(1).toString());
//            item.setPrice(onPostData.get(j).get(2).toString());
//            item.setQuantity(onPostData.get(j).get(3).toString());
//            inventoryItem.add(item);

        }
    }

}
