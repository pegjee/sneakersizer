package com.example.sneakersizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_chooser_manual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_manual);

        //populate spinner for new sneaker brands
        Spinner spinnerBrands2 = (Spinner) findViewById(R.id.spinnerBrands2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapterBrands = ArrayAdapter.createFromResource(this,
                R.array.brands_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterBrands.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBrands2.setAdapter(adapterBrands);

        //populate spinner for new sneaker models
        spinnerBrands2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spinnerModel = findViewById(R.id.spinnerModels2);
            populateModels(adapterBrands.getItem(i),spinnerModel);

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

}
    public void populateModels(CharSequence brand, Spinner spinnerModels){

        //Spinner spinnerModels = findViewById(R.id.spinnerModels);
        ArrayAdapter<CharSequence> adapterModels;

        switch((String) brand){
            case "Adidas":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_adidas, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);
                break;
            case "Converse":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_converse, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);

                break;
            case "New Balance":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_newbalance, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);

                break;
            case "Nike":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_nike, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);

                break;
            case "Reebok":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_reebok, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);

                break;
            case "Skechers":
                adapterModels = ArrayAdapter.createFromResource(this,
                        R.array.models_skechers, android.R.layout.simple_spinner_item);
                adapterModels.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerModels.setAdapter(adapterModels);

                break;
            default:
                break;
        }

    }

/*
    public void populateMeasurements(View view){
        //setup adapter for spinner measurements
        ArrayAdapter<CharSequence> adapterMeasurements;

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        Object[] array_cm = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,22,23,24,25,26,27,28,29,30,31,32};
        Object[] array_inch = {2,2.5,3,3.5,4,4.5,5.5,6,6.5,7,7.5,8,8.5,9,9.5,10,10.5,11,11.5,12, 12.5};

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_cm:
                if (checked)
                // populate in cm
                {
                    Spinner spinnerLength = (Spinner) findViewById(R.id.spinnerLength);
                    Spinner spinnerWidth = (Spinner) findViewById(R.id.spinnerWidth);

                    adapterMeasurements = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,array_cm);
                    adapterMeasurements.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerLength.setAdapter(adapterMeasurements);
                    spinnerWidth.setAdapter(adapterMeasurements);

                }
                break;
            case R.id.radio_inch:
                if (checked)
                // populate in inches
                {
                    Spinner spinnerLength = (Spinner) findViewById(R.id.spinnerLength);
                    Spinner spinnerWidth = (Spinner) findViewById(R.id.spinnerWidth);

                    adapterMeasurements = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,array_inch);
                    adapterMeasurements.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerLength.setAdapter(adapterMeasurements);
                    spinnerWidth.setAdapter(adapterMeasurements);

                }
                break;

        }


    }
*/


    public String getCheckedRadioButtonText(View v){
        RadioGroup rg = (RadioGroup) v;
        int selectedID = rg.getCheckedRadioButtonId();
        String r = "";
        if (selectedID!=-1) {
            RadioButton rbutton = (RadioButton) findViewById(selectedID);
            r= (String) rbutton.getText();
        }
        return r;
    }

    public String getSpinnerText(View v){
        String r = "";
        Spinner s=(Spinner) v;
        r=(String) s.getSelectedItem();
        //Toast.makeText(getApplicationContext(), r, Toast.LENGTH_SHORT).show();
        return r;
    }

    public void getResults(View v){
        Intent gotoChooser = new Intent();
        gotoChooser.setClass(this, results.class);

        //radio groups
        View radiogroupGenderNew = findViewById(R.id.radio_group_gender3);
        //View radiogroupUnits = findViewById(R.id.radio_group_units);

        //spinners
        View spinnerBrandNew = findViewById(R.id.spinnerBrands2);
        View spinnerModelNew = findViewById(R.id.spinnerModels2);

        //text inputs
        EditText textLength = (EditText)findViewById(R.id.textLength);
        EditText textWidth = (EditText)findViewById(R.id.textWidth);
        String length = textLength.getText().toString();
        String width = textWidth.getText().toString();
        //Toast.makeText(getApplicationContext(), "Text Length is "+textLength.getText().getClass(), Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(),"Text Width is "+textWidth.getText(), Toast.LENGTH_SHORT).show();

        gotoChooser.putExtra("genderNew",getCheckedRadioButtonText(radiogroupGenderNew));
        gotoChooser.putExtra("brandNew",getSpinnerText(spinnerBrandNew));
        gotoChooser.putExtra("modelNew",getSpinnerText(spinnerModelNew));
        //gotoChooser.putExtra("units",getCheckedRadioButtonText(radiogroupUnits));
        gotoChooser.putExtra("length",length);
        gotoChooser.putExtra("width", width);

        gotoChooser.putExtra("source","manual");



        startActivity(gotoChooser);



    }
}


