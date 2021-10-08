package com.example.ttdidog;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Base {
    private Button donateButton;
    private TextView donateTitle;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private ActionBar actionBar;
    private ImageButton memuReport;
    private int totalDonated = 0;
    private EditText amountText;
    private TextView amountTotal;


    public void donateButtonPressed (View view)
    {   int donatedAmount;
        int valueInput=0;
//        if(amountText.getText()!=null){
//           valueInput=Integer.parseInt(amountText.getText().toString());
//           donatedAmount = amountPicker.getValue() + valueInput;
//        }else{
//            donatedAmount=amountPicker.getValue();
//        }

        donatedAmount=amountPicker.getValue();
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ?
                "PayPal" : "Direct";



        if (donatedAmount == 0)
        {
            String text = amountText.getText().toString();
            if (!text.equals(""))
                donatedAmount = Integer.parseInt(text);
        }
        if (donatedAmount > 0)
        {
            totalDonated+=donatedAmount;
            newDonation(new Donation(donatedAmount, method));
            progressBar.setProgress(totalDonated);
            String totalDonatedStr = "$" + String.valueOf(totalDonated);
            amountTotal.setText(totalDonatedStr);
        }
        Log.v("donate",String.valueOf(donatedAmount));
        amountText.setText("");
        amountPicker.setValue(0);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean[] isVisible = {true};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donateButton=(Button)findViewById(R.id.donateButton);
        donateTitle=(TextView)findViewById(R.id.donateTitle);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);
        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        amountPicker.setValue(0);
        progressBar.setMax(10000);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        View viewMenu = (View) findViewById(R.id.viewMenu);
        ImageButton butonMenu= (ImageButton) findViewById(R.id.menuBtn);
        amountText = (EditText) findViewById(R.id.paymentAmount);

        amountTotal = (TextView) findViewById(R.id.totalSoFar);
        amountPicker.setValue(1);



        //
        butonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isVisible[0]) {
                    isVisible[0] = true;
                    viewMenu.setVisibility(View.INVISIBLE);
                }
                else {
                    isVisible[0] = false;
                    viewMenu.setVisibility(View.GONE);

                }

            }

        });
        Button reportBtn= (Button) findViewById(R.id.reportBtn);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("nam","report");
                Intent reportScreen= new Intent(MainActivity.this, ReportActivity.class);
                startActivity(reportScreen);


            }
        });

        Button doneBtn=(Button) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                String a=  amountText.getText().toString();
                Log.v("donate",a);
            }
        }));

//        setSupportActionBar(toolbar);



//
//
//        donateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view) {
//                if (donateButton != null)
//                {
//
//                    Log.v("Donate","oki");
//                }
//            }
//        });

    }

}