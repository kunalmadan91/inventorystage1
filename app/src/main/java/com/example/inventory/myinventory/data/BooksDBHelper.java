package com.example.inventory.myinventory.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KUNAL on 05-01-2018.
 */

public class BooksDBHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = BooksDBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "books.db";
    private static final int DATABSE_VERSION = 1;

    public BooksDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + BooksContract.BooksEntry.TABLE_NAME + " (" +
                BooksContract.BooksEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BooksContract.BooksEntry.COLUMN_BOOK_NAME + " TEXT NOT NULL, " +
                BooksContract.BooksEntry.COLUMN_BOOK_PRICE + " DOUBLE NOT NULL DEFAULT 0, " +
                BooksContract.BooksEntry.COLUMN_BOOK_QUANTITY + " INTEGER NOT NULL DEFAULT 0, " +
                BooksContract.BooksEntry.COLUMN_BOOK_IMAGEPATH + " TEXT NOT NULL, " +
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERNAME + " TEXT NOT NULL, " +
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIEREMAIL + " TEXT NOT NULL, " +
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERPHONE + " TEXT NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertBooks(String bookName, double price, String quantity, String imagePath, String
            supplierName, String email, String phone) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_NAME, bookName);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_PRICE, price);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_QUANTITY, quantity);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_IMAGEPATH, imagePath);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERNAME, supplierName);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIEREMAIL, email);
        contentValues.put(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERPHONE, phone);

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        long result = sqLiteDatabase.insert(BooksContract.BooksEntry.TABLE_NAME, null, contentValues);

        if (result != -1) {
            Log.d(LOG_TAG, "Books inserted successfully with row ID " + result);
        } else {
            Log.d(LOG_TAG, "Insert unsuccessful");
        }

    }


    public Cursor readAllBooks() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] projection = {
                BooksContract.BooksEntry._ID,
                BooksContract.BooksEntry.COLUMN_BOOK_NAME,
                BooksContract.BooksEntry.COLUMN_BOOK_PRICE,
                BooksContract.BooksEntry.COLUMN_BOOK_QUANTITY,
                BooksContract.BooksEntry.COLUMN_BOOK_IMAGEPATH,
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERNAME,
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIEREMAIL,
                BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERPHONE
        };

        Cursor cursor = sqLiteDatabase.query(BooksContract.BooksEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }


}
