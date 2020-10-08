package com.example.sneakersizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();

        TextView t = (TextView)findViewById(R.id.textShoeDescription);

        String source = intent.getStringExtra("source");
        String genderNew = intent.getStringExtra("genderNew");
        String brandNew = intent.getStringExtra("brandNew");
        String modelNew = intent.getStringExtra("modelNew");

        shoePicture(modelNew);

        if(source.equals("owned")) {
            //fields from "Owned" activity
            String sizeRegion = intent.getStringExtra("sizeRegion");
            String sizeOwned = intent.getStringExtra("sizeOwned");
            String brandOwned = intent.getStringExtra("brandOwned");
            String modelOwned = intent.getStringExtra("modelOwned");
            String genderOwned = intent.getStringExtra("genderOwned");
            calcSizeOwn(sizeOwned,modelOwned,genderOwned,sizeRegion);
            /*
            t.setText("Source: "+source+
                    "\nGenderOwned: "+genderOwned+
                    "\nGenderNew: "+genderNew+
                    "\nsizeRegion: "+sizeRegion+
                    "\nsizeOwned: "+sizeOwned+
                    "\nbrandOwned: "+brandOwned+
                    "\nbrandNew: "+brandNew+
                    "\nmodelOwned: "+modelOwned+
                    "\nmoelNew: "+modelNew);
            */

        }else if(source.equals("manual")) {

            //fields from "Manual" activity
            String length = intent.getStringExtra("length");
            String width = intent.getStringExtra("width");
            //String units = intent.getStringExtra("units");

            calcSizeManual(length,width);
            /*
            t.setText("Source: "+source+
                    "\nlength: "+length+
                    "\nGenderNew: "+genderNew+
                    "\nWidth: "+width+
                    "\nBrandNew: "+brandNew+
                    "\nModelNew: "+modelNew);

         */
        }

    }


    public void shoePicture(String shoeName){
        ImageView pic = (ImageView)findViewById(R.id.imageShoeResult);
        switch (shoeName) {
            case "Adidas Swift Run":
                pic.setImageResource(R.drawable.shoe_adidas_swiftrun);
                break;
            case "Adidas Stan Smith":
                pic.setImageResource(R.drawable.shoe_adidas_stansmith);
                break;
            case "Adidas Nite Jogger":
                pic.setImageResource(R.drawable.shoe_adidas_nitejogger);
                break;
            case "Nike Air Max 90":
                pic.setImageResource(R.drawable.shoe_nike_airmax90);
                break;
            case "Nike Air Force 1":
                pic.setImageResource(R.drawable.shoe_nike_airforce);
                break;
            case "Nike Air Jordan 1":
                pic.setImageResource(R.drawable.shoe_nike_airjordan);
                break;
            case "Reebok Classic Leather":
                pic.setImageResource(R.drawable.shoe_reebok_classicleather);
                break;
            case "Reebok Workout Plus":
                pic.setImageResource(R.drawable.shoe_reebok_workoutplus);
                break;
            case "Reebok Sole Fury":
                pic.setImageResource(R.drawable.shoe_reebok_solefury);
                break;
            case "New Balance 827":
                pic.setImageResource(R.drawable.shoe_newbal_827);
                break;
            case "New Balance 992":
                pic.setImageResource(R.drawable.shoe_newbal_992);
                break;
            case "New Balance 1500":
                pic.setImageResource(R.drawable.shoe_newbal_1500);
                break;
            case "Converse Chuck Taylor All Star":
                pic.setImageResource(R.drawable.shoe_converse_chucktaylor);
                break;
            case "Converse Chuck 70":
                pic.setImageResource(R.drawable.shoe_converse_chuck70);
                break;
            case "Converse One Star":
                pic.setImageResource(R.drawable.shoe_converse_onestar);
                break;
            case "Skechers Arch Fit":
                pic.setImageResource(R.drawable.shoe_skechers_archfit);
                break;
            case "Skechers GOwalk 5":
                pic.setImageResource(R.drawable.shoe_skechers_gowalk5);
                break;
            case "Skechers Summits":
                pic.setImageResource(R.drawable.shoe_skechers_summits);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shoeName);
        }
    }


    public void calcSizeOwn(String oldSize, String oldModel, String oldGender, String sizeRegion){
        TextView t = (TextView)findViewById(R.id.textShoeDescription);
        t.setText(oldSize+" "+sizeRegion);
    }

    public void calcSizeManual(String l, String w) {
        TextView t = (TextView) findViewById(R.id.textShoeDescription);
        Float length = Float.parseFloat(l);
        Float width = Float.parseFloat(w);

        if(length<24){
            t.setText(R.string.sizeErrorMsg);
        }
        if(length>=24 && length <=24.5){
            t.setText("7 US");
        }
        else if (length>24.5 && length <= 25.2){
            t.setText("8 US");
        }
        else if (length > 25.2 && length <=26){
            t.setText("9 US");
        }
        else if (length > 26 && length <= 26.8){
            t.setText("10 US");
        }
        else if (length > 26.8 && length <= 27.8){
            t.setText("11 US");
        }
        else if (length > 27.8 && length <= 28.6){
            t.setText("12 US");
        }
        else if (length > 28.6 && length <= 29.4){
            t.setText("13 US");
        }
        else if (length > 29.4){
            t.setText(R.string.sizeErrorMsg);
        }

    }

    public void startAgain(View v){
        Intent gotoChooser = new Intent();
        gotoChooser.setClass(this, MainActivity.class);
        startActivity(gotoChooser);
    }

}