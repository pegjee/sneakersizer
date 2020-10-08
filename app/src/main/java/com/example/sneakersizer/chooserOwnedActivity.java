package com.example.sneakersizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class chooserOwnedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_owned);

        //populate spinner for current sneaker brands
        Spinner spinnerBrands = (Spinner) findViewById(R.id.spinnerBrands);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapterBrands = ArrayAdapter.createFromResource(this,
                R.array.brands_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterBrands.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerBrands.setAdapter(adapterBrands);

        //populate spinner for current sneaker models
        spinnerBrands.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinnerModel = findViewById(R.id.spinnerModels);
                populateModels(adapterBrands.getItem(i),spinnerModel);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //populate spinner for new sneaker brands
        Spinner spinnerBrands2 = (Spinner) findViewById(R.id.spinnerBrands2);
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

    public void populateSizes(View view){
        //setup adapter for spinner sizes



        ArrayAdapter<CharSequence> adapterSizes;

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioSizeUS:
                if (checked)
                    // US size selected, populate US sizes
                {
                    Spinner spinnerSizes = (Spinner) findViewById(R.id.spinnerSizes);

                    adapterSizes = ArrayAdapter.createFromResource(this,
                            R.array.sizes_us, android.R.layout.simple_spinner_item);
                    adapterSizes.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerSizes.setAdapter(adapterSizes);

                }
                break;
            case R.id.radioSizeEU:
                if (checked)
                    // EU size selected, populate EU sizes
                {
                    Spinner spinnerSizes = (Spinner) findViewById(R.id.spinnerSizes);

                    adapterSizes = ArrayAdapter.createFromResource(this,
                            R.array.sizes_eu, android.R.layout.simple_spinner_item);
                    adapterSizes.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerSizes.setAdapter(adapterSizes);

                }
                break;

        }


    }


    public void populateModels(CharSequence brand, Spinner spinnerModels){

        //Toast.makeText(getApplicationContext(),brand,Toast.LENGTH_LONG).show();


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

    public void validateFields(){

    }

    public void getResults(View v){
        Intent gotoChooser = new Intent();
        gotoChooser.setClass(this, results.class);

        //radio groups
        View radioGroupGenderOwned = findViewById(R.id.radio_group_gender1);
        View radiogroupGenderNew = findViewById(R.id.radio_group_gender2);
        View radioGroupSizeRegion = findViewById(R.id.radio_group_size_region);

        //spinners
        View spinnerSizeOwned = findViewById(R.id.spinnerSizes);
        View spinnerBrandOwned = findViewById(R.id.spinnerBrands);
        View spinnerBrandNew = findViewById(R.id.spinnerBrands2);
        View spinnerModelOwned = findViewById(R.id.spinnerModels);
        View spinnerModelNew = findViewById(R.id.spinnerModels2);

        gotoChooser.putExtra("genderOwned",getCheckedRadioButtonText(radioGroupGenderOwned));
        gotoChooser.putExtra("genderNew",getCheckedRadioButtonText(radiogroupGenderNew));
        gotoChooser.putExtra("sizeRegion",getCheckedRadioButtonText(radioGroupSizeRegion));
        gotoChooser.putExtra("sizeOwned",getSpinnerText(spinnerSizeOwned));
        gotoChooser.putExtra("brandOwned",getSpinnerText(spinnerBrandOwned));
        gotoChooser.putExtra("brandNew",getSpinnerText(spinnerBrandNew));
        gotoChooser.putExtra("modelOwned",getSpinnerText(spinnerModelOwned));
        gotoChooser.putExtra("modelNew",getSpinnerText(spinnerModelNew));

        gotoChooser.putExtra("source","owned");



        startActivity(gotoChooser);
    }
}