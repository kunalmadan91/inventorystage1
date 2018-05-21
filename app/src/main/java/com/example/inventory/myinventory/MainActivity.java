package com.example.inventory.myinventory;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.inventory.myinventory.data.BooksContract;
import com.example.inventory.myinventory.data.BooksDBHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] images = getResources().getIntArray(R.array.images);

        BooksDBHelper booksDBHelper = new BooksDBHelper(this);

        //insert book 1
        booksDBHelper.insertBooks("Android basics",
                250.0,
                "23",
                "www.xyz.jpg",
                "Android labs",
                "abc@gmail.com",
                "011254778");


        //insert book 2
        booksDBHelper.insertBooks("Android Advanced",
                278.0,
                "ddd",
                "www.pqrs.jpg",
                "Pearson Labs",
                "xyz@gmail.com",
                "012445447");

        Cursor cursor = booksDBHelper.readAllBooks();

        try {
            int idColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_NAME);
            int priceColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_QUANTITY);
            int imagepathColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_IMAGEPATH);
            int supplierNameColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERNAME);
            int supplierEmailColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIEREMAIL);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(BooksContract.BooksEntry.COLUMN_BOOK_SUPPLIERPHONE);


            Log.d(LOG_TAG, "ID , NAME , PRICE , QUANTITY , IMAGEPATH , SUPPLIERNAME , SUPPLIEREMAIL , SUPPLIERPHONE");
            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                double price = cursor.getDouble(priceColumnIndex);
                int quantity = cursor.getInt(quantityColumnIndex);
                String imagePath = cursor.getString(imagepathColumnIndex);
                String supplierName = cursor.getString(supplierNameColumnIndex);
                String supplierEmail = cursor.getString(supplierEmailColumnIndex);
                String supplierPhone = cursor.getString(supplierPhoneColumnIndex);

                Log.d(LOG_TAG, id + " " + name + " " + price + " " + quantity + " " + imagePath + " " + supplierName + " " + supplierEmail + " " + supplierPhone);
            }
        } finally {
            cursor.close();
        }

    }
}
