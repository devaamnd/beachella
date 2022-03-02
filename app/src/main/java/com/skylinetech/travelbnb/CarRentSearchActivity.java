package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.skylinetech.travelbnb.adapters.DetailsViewpagerAdapter;

import java.util.Calendar;

public class CarRentSearchActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView departdate, returndate;
    private static String DATEPICKER_TAG = "";
    Button btnFlightSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent_search);


        departdate = findViewById(R.id.pickup_date);
        returndate = findViewById(R.id.dropoff_date);
        btnFlightSearch = findViewById(R.id.btn_Search_Cars);


        btnFlightSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CarSearchResultActivity.class));
            }
        });

    }


    public void DropoffDateDialog(View v) {
        DialogFragment newFragment = new CarRentSearchActivity.DropoffDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker1");
    }

    public void PickupDateDialog(View v) {
        DialogFragment newFragment = new CarRentSearchActivity.PickupDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker2");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        if (DATEPICKER_TAG.trim().equals("PICKUP")) {
            departdate.setText(day + "/" + month + "/" + year);
        }else if (DATEPICKER_TAG.trim().equals("DROPOFF")){
            returndate.setText(day + "/" + month + "/" + year);
        }
    }


    public static class PickupDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICKER_TAG = "PICKUP";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }

    public static class DropoffDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICKER_TAG = "DROPOFF";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }
}