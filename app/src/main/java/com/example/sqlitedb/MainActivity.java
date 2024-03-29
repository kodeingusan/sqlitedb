package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick (View v)
    {
        if (v.getId()==R.id.Blogin)         {
            EditText a = (EditText)findViewById(R.id.TFusername);
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String str = a.getText().toString();
            String pass = b.getText().toString();
            String password = helper.searchPass(str);
            if (a.length()==0 && b.length()==0) {
                a.setError("Mohon di isi");
                b.setError("Mohon di isi");
            } else if (a.length()==0) {
                a.setError("Mohon di isi");
            } else if (b.length()==0) {
                b.setError("Mohon di isi");
            } else if (pass.equals(password)) {
                Intent i = new Intent(MainActivity.this, TampilActivity.class);
                startActivity(i);
            } else{
                Toast.makeText(MainActivity.this,"Password dont match", Toast.LENGTH_SHORT).show();
            }
    }
        if (v.getId()==R.id.bregister) {
            Intent i = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(i);
        }
    }
}
