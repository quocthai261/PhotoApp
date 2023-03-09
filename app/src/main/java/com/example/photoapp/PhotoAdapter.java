package com.example.photoapp;

import static com.example.photoapp.SetImageByUrlExample2.loadImageFromUrl;
import static com.example.photoapp.SetImageByUrlExample2.loadImageFromUrl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private ArrayList<Photo> photo;
    private Context context;
    public PhotoAdapter(ArrayList<Photo> photo, Context context){
        this.photo = photo;
        this.context = context;
    }
    @Override
    public int getCount(){
        return photo.size();
    }

    @Override
    public Object getItem(int position) {
        return photo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photo.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final MyView dataitem;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null){
            dataitem = new MyView();
            view = inflater.inflate(R.layout.photo_disp_tpl,null);
            dataitem.iv_photo = view.findViewById(R.id.imv_photo);
            dataitem.tv_caption = view.findViewById(R.id.tv_title);
            view.setTag(dataitem);

        }
        else {
            dataitem = (MyView) view.getTag();
        }
        // new DownloadImage(dataitem.iv_photo).execute(photo.get(position).getSource_photo());
        dataitem.tv_caption.setText(photo.get(position).getTitle_photo());
        // Picass.get().load(photo.get(position).getSource_photo()).resize(300,400).centerCrop().into(dataitem.iv_photo);

        loadImageFromUrl(photo.get(position).getSource_photo(),dataitem.iv_photo);

        return view;
    }
    private static class MyView{
        ImageView iv_photo;
        TextView tv_caption;
    }
}

