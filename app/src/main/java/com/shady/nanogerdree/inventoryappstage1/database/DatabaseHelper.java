package com.shady.nanogerdree.inventoryappstage1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shady.nanogerdree.inventoryappstage1.model.Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shady on 3/26/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_INVENTORY = "inventory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT_NAME = "productName";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SUPPLIER_NAME = "supplierName";
    public static final String COLUMN_SUPPLIER_PHONE_NUMBER = "supplierPhoneNumber";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        InventoryTable.onCreate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        InventoryTable.onUpgrade(sqLiteDatabase,i,i1);
    }

    public boolean insertRecord (Inventory inventory) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PRODUCT_NAME, inventory.productName);
        contentValues.put(COLUMN_PRICE, inventory.price);
        contentValues.put(COLUMN_QUANTITY, inventory.quantity);
        contentValues.put(COLUMN_SUPPLIER_NAME, inventory.supplierName);
        contentValues.put(COLUMN_SUPPLIER_PHONE_NUMBER, inventory.supplierPhoneNumber);
        db.insert(TABLE_INVENTORY, null, contentValues);
        db.close();
        return true;
    }

    public List<Inventory> getAllRecords() {
        List<Inventory> list = new ArrayList<>();
        Inventory inventory = new Inventory();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c =  db.rawQuery( "select * from " + TABLE_INVENTORY, null );
        c.moveToFirst();

        while(c.isAfterLast() == false){
            inventory.productName = c.getString(1);
            inventory.price = c.getInt(2);
            inventory.quantity = c.getInt(3);
            inventory.supplierName = c.getString(4);
            inventory.supplierPhoneNumber = c.getString(5);
            list.add(inventory);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
