package com.example.user.memo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    Button button;
    Button button2;
    Button button3;
    MemoAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.btn01);
        button2 = (Button)findViewById(R.id.btn02);
        button3 = (Button)findViewById(R.id.btn03);


        listView = (ListView)findViewById(R.id.listview);
         adapter = new MemoAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item #" + position + "Clicked.",Toast.LENGTH_LONG).show();
            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MemoInputActivity.class);
                intent.putExtra("mode","create");
                startActivityForResult(intent,1001);

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PasswordSettingActivity.class);
                intent.putExtra("mode","lock");
                startActivityForResult(intent,1002);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


       String passwordUseYn = loadPasswordUseYn(this);
       if (passwordUseYn != null && passwordUseYn.equals("Y")) {
           Intent intent = new Intent(getApplicationContext(), PasswordSettingActivity.class);
         intent.putExtra("mode", "unlock");
           startActivityForResult(intent, 1002);
        }
   }

   /**
////     * 환경 정보에서 비밀번호 사용 여부 가져오기
////     */
    public String loadPasswordUseYn(Context context){
        SharedPreferences preferences = context.getSharedPreferences("environ", 0);
        return preferences.getString("passwordUseYn", "N");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG,"onActivity Called :" + requestCode +" "+resultCode);
        if(requestCode == 1001){
            String mode = data.getStringExtra("mode");
            String contents = data.getStringExtra("contents");
            String firendName = data.getStringExtra("firendName");
            String frinedMoblie = data.getStringExtra("frinedMoblie");
            String timeStamp = data.getStringExtra("timeStamp");
            Bitmap imageBitmap = (Bitmap) data.getParcelableExtra("imageBitmap");


            Toast.makeText(getApplicationContext(),"mode :" +mode +"contents :" +contents +
            "firendName :" + firendName +"frinedMoblie : " +frinedMoblie +"timeStamp :" +timeStamp
            ,Toast.LENGTH_LONG).show();

            if(mode != null && mode.equals("create")){
                MemoItem item = new MemoItem(contents,firendName,frinedMoblie,timeStamp,imageBitmap);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();
            }} else if (requestCode == 1002) {
            if (data != null) {
                String mode = data.getStringExtra("mode");
                if (mode != null && mode.equals("exit")) {
                    finish();
                }
            }
        }
    }
}
