package com.example.ttdidog;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ttdidog.Donation;
import com.example.ttdidog.MainActivity;
import com.example.ttdidog.R;
import com.example.ttdidog.ReportActivity;

import java.util.ArrayList;
import java.util.List;

public class Base extends AppCompatActivity
{
    public final int target = 10000;
    public int totalDonated = 0;
    public static List <Donation> donations = new ArrayList<Donation>();
    public boolean newDonation(Donation donation)
    {
        boolean targetAchieved = totalDonated > target;
        if (!targetAchieved)
        {
            donations.add(donation);
            totalDonated += donation.amount;
        }
        else
        {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return targetAchieved;
    }

//    @Override
//    public boolean onPrepareOptionsMenu (Menu menu){
//        super.onPrepareOptionsMenu(menu);
//        MenuItem report = menu.findItem(R.id.reportBtn);
//        MenuItem donate = menu.findItem(R.id.donateButton);
//        if(donations.isEmpty())
//            report.setEnabled(false);
//        else
//            report.setEnabled(true);
//
//        return true;
//    }
    public void settings(MenuItem item)
    {
        Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
    }
    public void report(MenuItem item)
    {
        startActivity (new Intent(this, ReportActivity.class));
    }
    public void donate(MenuItem item)
    {
        startActivity (new Intent(this, MainActivity.class));
    }
}