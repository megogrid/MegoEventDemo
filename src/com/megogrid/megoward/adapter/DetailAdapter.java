package com.megogrid.megoward.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.megogrid.megoward.R;
import com.megogrid.megoward.db.ImageDetail;


import java.util.ArrayList;

/**
 * Created by divya on 11/2/16.
 */
public class DetailAdapter  extends BaseAdapter {
    Context context;
    ArrayList<ImageDetail> detail;
    LayoutInflater inflatelayout;

    public DetailAdapter(Context context,ArrayList<ImageDetail> detail) {
        this.context = context;
        this.detail = detail;
        inflatelayout = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return detail.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHandler holder;

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder = new ViewHandler();
        convertView = inflatelayout.inflate(R.layout.detailforlistview, null);
        holder.imagename = (TextView) convertView.findViewById(R.id.imagename);
        holder.effectname = (TextView) convertView.findViewById(R.id.effectname);
        holder.datetime = (TextView) convertView.findViewById(R.id.datetime);
        holder.picimage = (ImageView) convertView.findViewById(R.id.imagesaved);
//        Bitmap bm = BitmapFactory.decodeFile(detail.get(position).getIcon());
//        holder.picimage.setImageBitmap(bm);
        holder.imagename.setText(detail.get(position).getImagename());
        holder.effectname.setText(detail.get(position).getEffectname());
        holder.datetime.setText(detail.get(position).getImagecapturedate());

        return convertView;
    }

    static class ViewHandler {
        TextView imagename, effectname, datetime;
        ImageView picimage;

    }

}
