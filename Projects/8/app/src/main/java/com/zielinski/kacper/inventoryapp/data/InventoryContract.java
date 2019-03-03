package com.zielinski.kacper.inventoryapp.data;

import android.provider.BaseColumns;

/**
 * Database schema
 * Final class cannot be extended!
 */

public final class InventoryContract {

    private InventoryContract() {}

    /**
     * Inner class that defines constant values for database table.
     */
    public static final class InventoryEntry implements BaseColumns {

        public final static String TABLE_NAME = "inventory";

        /**
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME = "product_name";

        /**
         * Type: REAL
         */
        public final static String COLUMN_PRICE = "price";

        /**
         * Type: INTEGER
         */
        public final static String COLUMN_QUANTITY = "quantity";

        /**
         * Type: TEXT
         */
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";

        /**
         * Type: TEXT
         */
        public final static String COLUMN_SUPPLIER_TELEPHONE_NUMBER = "supplier_telephone_number";

    }

}