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

import com.skylinetech.travelbnb.classes.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FlightSearchActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView departdate, returndate;
    private static String DATEPICKER_TAG = "";
    Button btnFlightSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search);

        departdate = findViewById(R.id.depart_date);
        returndate = findViewById(R.id.return_date);
        btnFlightSearch = findViewById(R.id.btn_flight_search);


        btnFlightSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FlightSearchResultActivity.class));
            }
        });

    }


    public void ReturnDateDialog(View v) {
        DialogFragment newFragment = new ReturnDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker1");
    }

    public void DateDialog(View v) {
        DialogFragment newFragment = new DepartDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker2");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        if (DATEPICKER_TAG.trim().equals("DEPART")) {
            departdate.setText(day + "/" + month + "/" + year);
        }else if (DATEPICKER_TAG.trim().equals("RETURN")){
            returndate.setText(day + "/" + month + "/" + year);
        }
    }


    public static class DepartDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICKER_TAG = "DEPART";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }

    public static class ReturnDatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DATEPICKER_TAG = "RETURN";
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }

    }
}