package com.example.user.memo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by user on 2017-03-16.
 */

public class MemoAdapter extends BaseAdapter {
    Context mContext;

    ArrayList<MemoItem> items =  new ArrayList<MemoItem>();

    public MemoAdapter(Context context){
        mContext = context;
    }



    public void addItem (MemoItem item){
        items.add(item);
    }


    public void clear() {
        items.clear();
    }


    @Override
    public int getCount() {
       return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoItemView view = null;
        if (convertView == null) {
            view = new MemoItemView(mContext);
        } else {
            view = (MemoItemView) convertView;
        }
        MemoItem item = items.get(position);

        view.setContents(item.getContents());
        view.setfirendName(item.getFirendName());
        view.setfrinedMoblie(item.getFrinedMoblie());
        view.settimeStamp(item.getTimeStamp());

        Bitmap imageBitmap = item.getImageBitmap();
        if (imageBitmap != null) {
            view.setImage(item.getImageBitmap());
        } else {
            view.setImageResource(R.drawable.memo1);
        }

        return  view;

    }
}
