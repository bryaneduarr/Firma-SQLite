package com.example.firma_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Signatures  extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "signatures.db";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_NAME = "photos";

  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_IMAGE = "image";
  public static final String COLUMN_FIRMAS = "firmas";

  public Signatures(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_IMAGE + " TEXT," + COLUMN_FIRMAS + " TEXT" + ")";
    db.execSQL(CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
  }

  public void addPhoto(String image, String firma) {
    SQLiteDatabase db = this.getWritableDatabase();

    String INSERT_PHOTO = "INSERT INTO " + TABLE_NAME + "(" + COLUMN_IMAGE + ", " + COLUMN_FIRMAS + ") VALUES('" + image + "', '" + firma + "')";

    db.execSQL(INSERT_PHOTO);

    db.close();
  }

  public ArrayList<FirmaItem> getAllFotos() {
    ArrayList<FirmaItem> fotoItems = new ArrayList<>();

    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

    if (cursor.moveToFirst()) {
      do {
        String imageBase64 = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));
        String firma = cursor.getString(cursor.getColumnIndex(COLUMN_FIRMAS));

        fotoItems.add(new FirmaItem(imageBase64, firma));
      } while (cursor.moveToNext());
    }
    cursor.close();

    db.close();

    return fotoItems;
  }
}
