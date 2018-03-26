package com.shady.nanogerdree.inventoryappstage1.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Shady on 3/26/2018.
 */

public class InventoryTable {
    public static final String TABLE_INVENTORY = "inventory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT_NAME = "productName";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SUPPLIER_NAME = "supplierName";
    public static final String COLUMN_SUPPLIER_PHONE_NUMBER = "supplierPhoneNumber";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_INVENTORY
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_PRODUCT_NAME + " text not null, "
            + COLUMN_PRICE + " integer not null,"
            + COLUMN_QUANTITY + " integer not null,"
            + COLUMN_SUPPLIER_NAME + " text not null,"
            + COLUMN_SUPPLIER_PHONE_NUMBER + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        onCreate(database);
    }


}
