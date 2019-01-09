package com.tsorrow.junior.file;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    private EditText edit;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        String inputText = load();
        if(!TextUtils.isEmpty(inputText)){
            edit.setText(inputText);
            edit.setSelection(inputText.length());
            Toast.makeText(this,"Restoring success",Toast.LENGTH_SHORT).show();
        }

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            accountEdit.setText(pref.getString("account",""));
            passwordEdit.setText(pref.getString("password",""));
            rememberPass.setChecked(true);
        }

        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String account = accountEdit.getText().toString();
                        String password = passwordEdit.getText().toString();
                        if (account.equals("admin")&&password.equals("123456")){
                            if(rememberPass.isChecked()){
                                editor.putString("account",account);
                                editor.putString("password",password);
                                editor.putBoolean("remember_password",true);
                            }else {
                                editor.clear();
                            }
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this,"accoount or password invalid",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );

    }

    @NonNull
    private String load() {
        FileInputStream fis = null;
        BufferedReader br = null;
        StringBuilder content = new StringBuilder();
        try {
            fis = openFileInput("test1");
            br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = br.readLine()) != null){
                content.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ( br != null){
                try{
                    br.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        String inputText = edit.getText().toString();
        save(inputText);
    }

    private void save(String inputText) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            fos = openFileOutput("test1", Context.MODE_PRIVATE);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(inputText);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (bw != null){
                    bw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
