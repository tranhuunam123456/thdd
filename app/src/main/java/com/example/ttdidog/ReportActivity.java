package com.example.ttdidog;

import static com.example.ttdidog.Base.donations;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ttdidog.databinding.ActivityReportBinding;

public class ReportActivity extends AppCompatActivity {
    ListView listView;
    private AppBarConfiguration appBarConfiguration;
    private ActivityReportBinding binding;
//    static final String[] numbers = new String[] {
//            "Amount, Pay method",
//            "10, Direct",
//            "100, PayPal",
//            "1000, Direct",
//            "10, PayPal",
//            "5000, PayPal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_report);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        listView = (ListView) findViewById(R.id.reportList);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        DonationAdapter adapter = new DonationAdapter(this,donations);
        listView.setAdapter(adapter);
        Button menuDonateBtn= (Button) findViewById(R.id.menuDonateBtn);
        menuDonateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("nam","report");
                Intent reportScreen= new Intent(ReportActivity.this, MainActivity.class);
                startActivity(reportScreen);


            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_report);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}