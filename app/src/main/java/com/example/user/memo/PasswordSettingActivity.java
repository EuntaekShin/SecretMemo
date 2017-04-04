package com.example.user.memo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by user on 2017-03-16.
 */

public class PasswordSettingActivity extends Activity {

    String mode;
    EditText editText45;
    EditText editText55;
    CheckBox checkBox;
    TextView textView5;
    Button button3;
    Button button4;




    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
             setContentView(R.layout.password_setting);

        editText45 = (EditText)findViewById(R.id.edittext45);
        editText55 = (EditText)findViewById(R.id.edittext55);
        checkBox = (CheckBox)findViewById(R.id.checkbox);
        textView5 =(TextView)findViewById(R.id.textView5);
        button3 =(Button)findViewById(R.id.button3);
        button4 =(Button)findViewById(R.id.button4);



            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String password1 = editText45.getText().toString().trim();
                    String password2 = editText55.getText().toString().trim();

                    if (!password1.equals(password2)) {
                        Toast.makeText(getApplicationContext(), "It's not Same", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (mode != null && mode.equals("lock")) {
                        savePasswordUseYn(getApplicationContext(), "Y");
                        savePassword(getApplicationContext(), password1);
                        Toast.makeText(getApplicationContext(), "Set up Password", Toast.LENGTH_LONG).show();
                        finish();
                    } else if (mode.equals("unlock")) {
                        String previousPassword = loadPassword(getApplicationContext());
                        if (password1.equals(previousPassword)) {
                            if (checkBox.isChecked()) {
                                savePasswordUseYn(getApplicationContext(), "N");
                                savePassword(getApplicationContext(), "");
                                Toast.makeText(getApplicationContext(), "Unlocked Password", Toast.LENGTH_LONG).show();
                                finish();

                            } else {
                                Toast.makeText(getApplicationContext(), "Confirmed Password", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Unidentify Value :"+mode, Toast.LENGTH_LONG).show();

                    }

                    }
            });


            button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (mode != null && mode.equals("unlock")) {
                        Intent intent = new Intent();
                        intent.putExtra("mode", "exit");
                        setResult(Activity.RESULT_CANCELED);

                        finish();
                    } else {
                        finish();
                    }
                }
            });


        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        if(mode != null && mode.equals("unlock")) {
            checkBox.setVisibility(View.VISIBLE);

            textView5.setText("Confirm Password");
            button3.setText("Confirm");
            button4.setText("Done");

        }else{
            checkBox.setVisibility(View.GONE);
            textView5.setText("Set up Password");
            button3.setText("SAVE");
            button4.setText("CANCLE");
        }


    }
    public void savePassword(Context context , String password){
        SharedPreferences preferences = context.getSharedPreferences("environ",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("password",password);
        editor.commit();
    }

        public String loadPassword(Context context){
        SharedPreferences preferences = context.getSharedPreferences("environ",0);
        return preferences.getString("password","");
    }
    public void savePasswordUseYn(Context context, String useYn) {
        SharedPreferences preferences = context.getSharedPreferences("environ", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passwordUseYn", useYn);
        editor.commit();

    }
}