package com.megogrid.megoward;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.megogrid.megoward.adapter.DetailAdapter;
import com.megogrid.megoward.db.ImageDetail;
import com.megogrid.megoward.db.SavedDbHelper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by divya on 11/2/16.
 */
public class SavedData extends Activity {

    ListView listview;
    DetailAdapter adapter;
    ArrayList<ImageDetail> detail;
    ImageDetail detailEntity;
    SavedDbHelper helper;
    SharedPreferences preferences;
//    Gson gson;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedetail);
//        gson = new Gson();
        detail = new ArrayList<ImageDetail>();
        preferences = getSharedPreferences("AppBackup", MODE_PRIVATE);
        listview = (ListView) findViewById(R.id.listViewSave);
        helper = new SavedDbHelper(SavedData.this);
        helper.getReadableDatabase();

        System.out.println("Database : " + helper.showAllDetail().size());
        System.out.println("Preference is " + preferences.getAll());

        String abc = null;
        try {
            JSONObject obj = new JSONObject(preferences.getAll());
            abc = obj.getString("json");
            JSONArray json1 = new JSONArray(abc);
            if (detail != null)
                detail.clear();
            System.out.println("abc>>> "+json1.length());
            for (int i = 0; i < json1.length(); i++) {
                JSONObject catObj = json1.getJSONObject(i);
//                ImageDetail category = gson.fromJson(catObj.toString(),
//                        ImageDetail.class);
//                detail.add(category);
            }
        } catch (JSONException e) {

            e.printStackTrace();
            System.out.println("Exception is " + e.getMessage());
        }


//        detail = helper.showAllDetail();
        setAllImageDataList();

    }

    public void setAllImageDataList() {

        if (detail.size() == 0) {
            Toast.makeText(SavedData.this, "List is Empty" + detail.size(), Toast.LENGTH_SHORT).show();
            finish();
        } else {
            adapter = new DetailAdapter(SavedData.this, detail);
            listview.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

    }
}
