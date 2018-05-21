package com.example.inventory.myinventory.data;

import android.provider.BaseColumns;

/**
 * Created by KUNAL on 05-01-2018.
 */

public class BooksContract {

    // Inner class to define constant values for the Books database table.
    // Each entry in the table represents a single Book.

    public static final class BooksEntry implements BaseColumns {

        //Name of the Table
        public static final String TABLE_NAME = "books";

        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_BOOK_NAME = "bookname";

        public static final String COLUMN_BOOK_PRICE = "price";

        public static final String COLUMN_BOOK_QUANTITY = "quantity";

        public static final String COLUMN_BOOK_IMAGEPATH = "image";

        public static final String COLUMN_BOOK_SUPPLIERNAME = "suppliername";

        public static final String COLUMN_BOOK_SUPPLIEREMAIL = "supplieremail";

        public static final String COLUMN_BOOK_SUPPLIERPHONE = "supplierphone";

    }
}
