package com.example.sitharawanigasooriy.ma;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.log4j.lf5.util.Resource;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Inventory extends AppCompatActivity implements InventoryInterface{
    private String[] inventoryHeader = {"Product Code", "Product Name", "Price","Qty"};
    private ArrayList<Item> inventoryItem = new ArrayList();
    ArrayList<String[][]> dataInventoryArray = new ArrayList<>();
    //public TableView<String[]> tb;
    DynamicTwoDArray inventoryData = new DynamicTwoDArray();
    private Button inventory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        inventory = (Button) findViewById(R.id.inventory);
        //creating the table
        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.inventorytable);

        tb.setColumnCount(4);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        //Adapters
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, inventoryHeader));

        //tb.SetColumnWeight(0, 2);
        populateData();


        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //when data click this will heppen
                Toast.makeText(Inventory.this, ((String[]) clickedData)[1], Toast.LENGTH_LONG).show();
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(String[][] i : dataInventoryArray) {
                    Log.i("myInfoTag", "+++");
                    tb.setDataAdapter(new SimpleTableDataAdapter(Inventory.this, i));

                }

            }
        });
    }

    public void populateData(){
        BackgroundWorker backgroundWorkerInventory = new BackgroundWorker(this);
        backgroundWorkerInventory.delegateInventory= Inventory.this;
        backgroundWorkerInventory.execute("inventoryAccess","inventory");
    }


    @Override
    public void returnData(ArrayList<ArrayList<String>> onPostData) {

        for(int j=0;j<onPostData.size();j++) {

            Item item = new Item();
            Log.i("myInfoTag--", j + "-------");
            inventoryData.add(j, 0, onPostData.get(j).get(0).toString());// 0-->code
            inventoryData.add(j, 1, onPostData.get(j).get(1).toString());// 2 --> Product name
            inventoryData.add(j, 2, onPostData.get(j).get(2).toString());// 3 --> price
            inventoryData.add(j, 3, onPostData.get(j).get(3).toString());// 4 --> quantity
            dataInventoryArray.add(inventoryData.toArray());

            //setting up the object
            item.setProduct_code(onPostData.get(j).get(0).toString());
            item.setProduct_name(onPostData.get(j).get(1).toString());
            item.setPrice(onPostData.get(j).get(2).toString());
            item.setQuantity(onPostData.get(j).get(3).toString());
            inventoryItem.add(item);

        }
    }






}
