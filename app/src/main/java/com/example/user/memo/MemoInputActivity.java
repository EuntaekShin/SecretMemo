package com.example.user.memo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;


/**
 * Created by user on 2017-03-16.
 */

public class MemoInputActivity extends AppCompatActivity {
    Button button;
    Button buttonCancle;
    Button button3;
    Button button4;
    EditText editText;
    EditText editText2;
    EditText editText3;
    TextView textView;
    TextView textView2;
    String mode;
    ImageView imageView;
   // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 년 MM 월 dd 일 HH 시 mm 분");
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
    Bitmap imageBitmap;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_input);

         button = (Button)findViewById(R.id.button);
        buttonCancle = (Button)findViewById(R.id.buttonCancle);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        editText =(EditText) findViewById(R.id.edittext);
        editText2 =(EditText) findViewById(R.id.edittext2);
        editText3 =(EditText) findViewById(R.id.edittext3);
        textView = (TextView) findViewById(R.id.textview);
        textView2 = (TextView) findViewById(R.id.textview2);
        imageView = (ImageView)findViewById(R.id.imageview);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents  =editText.getText().toString();
                String firendName = editText2.getText().toString();
                String frinedMoblie = editText3.getText().toString();
                String timeStamp =textView.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("mode",mode);
                intent.putExtra("contents",contents);
                intent.putExtra("firendName",firendName);
                intent.putExtra("frinedMoblie",frinedMoblie);
                intent.putExtra("timeStamp",timeStamp);
                intent.putExtra("imageBitmap", imageBitmap);

                setResult(Activity.RESULT_OK,intent);
                finish();


            }
        });

      buttonCancle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1004);
            }
        });

        // 전화 버튼 설정
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" + friendMobile));
                startActivity(intent);
            }
        });

        // 문자 버튼 설정
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("address", friendMobile);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });

        // 전달된 인텐트 데이터 처리
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");

        if(mode != null && mode.equals("create")) {
            Date date = new Date();
            String timeStamp = dateFormat.format(date);
            textView.setText(timeStamp);

        } else if (mode.equals("modify")) {
            String contents = intent.getStringExtra("contents");
            String friendName = intent.getStringExtra("friendName");
            String friendMobile = intent.getStringExtra("friendMobile");
            String timestamp = intent.getStringExtra("timestamp");
            Bitmap imageBitmap = intent.getParcelableExtra("imageBitmap");

            textView.setText("Change Memo");

            editText.setText(contents);
            editText2.setText(friendName);
            editText3.setText(friendMobile);
            textView2.setText(timestamp);
            imageView.setImageBitmap(imageBitmap);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1004 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
    }







//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            if (requestCode == 1004 && resultCode == RESULT_OK) {
//                Bundle extras = data.getExtra();
//                imageBitmap = (Bitmap) extras.get("data");
//                imageView.setImageBitmap(imageBitmap);
//            }
//        }





