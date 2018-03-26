package com.shady.nanogerdree.inventoryappstage1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shady.nanogerdree.inventoryappstage1.database.DatabaseHelper;
import com.shady.nanogerdree.inventoryappstage1.model.Inventory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        Inventory inventory = new Inventory();
        inventory.productName = "Product 1";
        inventory.price = 10;
        inventory.quantity = 1;
        inventory.supplierName = "Supplier 1";
        inventory.supplierPhoneNumber = "0123456789";

        Boolean dataInserted = db.insertRecord(inventory);
        Log.e("DataInserted", "DataInserted " + dataInserted);

        List<Inventory> recordslist = db.getAllRecords();
        if (recordslist.size() > 0){
            Inventory inventory1 = recordslist.get(0);
            Log.e("RecordsList",
                    "ProductName:" + inventory1.productName
                    + ", Price:" + inventory1.price
                    + ", Quantity:" + inventory1.quantity
                    + ", SupplierName:" + inventory1.supplierName
                    + ", SupplierPhoneNumber:" + inventory1.supplierPhoneNumber
            );
        }

    }
}
