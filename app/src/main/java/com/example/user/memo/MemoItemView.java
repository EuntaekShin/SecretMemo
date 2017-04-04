package com.example.user.memo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 2017-03-16.
 */

public class MemoItemView extends LinearLayout {
    Context mContext;

    TextView  textView1;
    TextView  textView2;
    TextView  textView3;
    TextView  textView4;
    ImageView imageView;

    public MemoItemView(Context context) {
        super(context);
        mContext= context;
        init();
    }

    public MemoItemView(Context context,AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.memo_item,this,true);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        imageView = (ImageView)findViewById(R.id.imageview);

    }//of init

    public void setContents(String contents){textView1.setText(contents);}
    public void setfirendName(String firendName){textView2.setText(firendName);}
    public void setfrinedMoblie(String frinedMoblie){textView3.setText(frinedMoblie);}
    public void settimeStamp(String timeStamp){textView4.setText(timeStamp);}
    public void setImage(Bitmap imageBitmap) {
        imageView.setImageBitmap(imageBitmap);
    }
    public void setImageResource(int resId) {
        imageView.setImageResource(resId);
    }

}
