package com.megogrid.megoward.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by divya on 11/2/16.
 */
public class SavedDbHelper extends SQLiteOpenHelper {

    /*
     * Database Name & Version
     */
    private static final String DATABASE_NAME = "savedinfodata_meuser.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_IMAGE = "imageDetaildata";
    private static final String COLUMN__ID = "id";
    private static final String CAPTURE__ICON = "icon";
    private static final String CAPTURE__ICON_NAME = "iconname";
    private static final String CAPTURE__ICONDATE = "capturedate";
    private static final String EFFECTS__ICON = "effects";
    public static final String CREATE_TABLE = "create table " + TABLE_IMAGE
            + "(" + COLUMN__ID + " text, " + CAPTURE__ICON + " text, "
            + CAPTURE__ICONDATE + " text, " + CAPTURE__ICON_NAME + " text, " + EFFECTS__ICON + " text);";

    Context context;
    SQLiteDatabase db;

    public SavedDbHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + File.separator + DATABASE_NAME, null,
                DATABASE_VERSION);
        this.context = context;
        db = getWritableDatabase();
    }

    public void insertData(ArrayList<ImageDetail> list) {
        ContentValues values = new ContentValues();
        db = getWritableDatabase();
        for (int i = 0; i < list.size(); i++) {
            values.put(COLUMN__ID, list.get(i).getId());
            values.put(CAPTURE__ICON, list.get(i).getIcon());
            values.put(CAPTURE__ICON_NAME, list.get(i).getImagename());
            values.put(CAPTURE__ICONDATE, list.get(i).getImagecapturedate());
            values.put(EFFECTS__ICON, list.get(i).getEffectname());
        }
        db.insert(TABLE_IMAGE, null, values);
    }

    ArrayList<ImageDetail> imagelist;

    public ArrayList<ImageDetail> showAllDetail() {
        Cursor cr = null;
        imagelist = new ArrayList<ImageDetail>();
        ImageDetail imagedetail;
        cr = db.query(TABLE_IMAGE, null, null, null, null, null, null);
        if (cr.moveToFirst()) {
            do {
                String id = cr.getString(0);
                String icon = cr.getString(1);
                String capture_date = cr.getString(2);
                String icon_name = cr.getString(3);
                String effect = cr.getString(4);
                imagedetail = new ImageDetail(id, icon, icon_name, effect, capture_date);
                imagelist.add(imagedetail);
            } while (cr.moveToNext());
        }
        return imagelist;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("checkdatabase<<<<<<<<<<<<<<<<<<<2");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("checkdatabase<<<<<<<<<<<<<<<<<<<3");
    }

}
