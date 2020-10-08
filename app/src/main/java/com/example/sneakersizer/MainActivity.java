package com.example.sneakersizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enter(View v) {
        //Toast hiToast = Toast.makeText(getApplicationContext(),"hi hi hi", Toast.LENGTH_SHORT);
        //hiToast.show();

        Intent gotoChooser = new Intent();
        gotoChooser.setClass(this, chooserOwnedActivity.class);
        startActivity(gotoChooser);
    }

    public void enterManual(View v){
        Intent gotoChooser = new Intent();
        gotoChooser.setClass(this, activity_chooser_manual.class);
        startActivity(gotoChooser);
    }

}