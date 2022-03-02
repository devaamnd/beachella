package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class HotelSearchActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    TextView fromdate, todate;
    private static String DATEPICK_TAG = "";
    Button btnHotelSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        fromdate = findViewById(R.id.from_date);
        todate = findViewById(R.id.to_date);
        btnHotelSearch = findViewById(R.id.btn_Search_Hotel);

        btnHotelSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HotelSearchResultsActivity.class));
            }
        });

    }

    public void ToDateDialog(View v) {
        DialogFragment newFragment = new HotelSearchActivity.ToDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker1");
    }

    public void FromDateDialog(View v) {
        DialogFragment newFragment = new HotelSearchActivity.FromDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker2");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        if (DATEPICK_TAG.trim().equals("FROM")) {
            fromdate.setText(day + "/" + month + "/" + year);
        }else if (DATEPICK_TAG.trim().equals("TO")){
            todate.setText(day + "/" + month + "/" + year);
        }
    }

    public static class FromDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICK_TAG = "FROM";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }

    public static class ToDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICK_TAG = "TO";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }
}