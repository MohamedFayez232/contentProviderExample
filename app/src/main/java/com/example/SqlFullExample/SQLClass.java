package com.example.SqlFullExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLClass extends SQLiteOpenHelper {

    final private static String DatabaseName = "ThisIsDatabaseName";
    final private static String TableName = "ThisIsTablename";
    final private static int DatabaseVersion = 1;
    final private static String Kay_Id = "id";
    final private static String COLUM_WORDS = "words";
    final private static String COLUM_EXPLAINING = "explaining";


    public SQLClass(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String CREATE_TABLE =
                "CREATE TABLE " + TableName + "("
                        + Kay_Id + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                        + COLUM_WORDS + " TEXT,"
                        + COLUM_EXPLAINING + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                        + ")";


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);

    }

    // Insert Word with explaining
    public void insertword(DataClass word) {

        ContentValues contentValues = new ContentValues();


        contentValues.put(COLUM_WORDS, word.getWord());
        contentValues.put(COLUM_EXPLAINING, word.getExplaining());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TableName, null, contentValues);
        sqLiteDatabase.close();
    }

    // this to display information
    public ArrayList<DataClass> displayinformatiofromuser() {

        Cursor cursor;
        SQLiteDatabase sqLiteDatabase;
        ArrayList<DataClass> arrayList;


         arrayList = new ArrayList<>();
         sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from " + TableName;
         cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(Kay_Id));
                String word = cursor.getString(cursor.getColumnIndex(COLUM_WORDS));
                String explaining = cursor.getString(cursor.getColumnIndex(COLUM_EXPLAINING));

                DataClass dataClass = new DataClass(word, explaining,id);
                arrayList.add(dataClass);
            }

            while (cursor.moveToNext());
        }
        return arrayList;
    }

}
