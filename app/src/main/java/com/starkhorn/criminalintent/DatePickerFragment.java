package com.starkhorn.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by starkhorn on 9/20/2015.
 */
public class DatePickerFragment extends DialogFragment {

    public static final String EXTRA_DATE = "com.starkhorn.criminalintent.date";
    private static final String ARG_DATE = "date";

    private DatePicker datepicker;

    public static DatePickerFragment newInstance(Date date) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        datepicker = (DatePicker) view.findViewById(R.id.dialog_date_date_picker);
        datepicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year = datepicker.getYear();
                        int month = datepicker.getMonth();
                        int day = datepicker.getDayOfMonth();
                        Date date = new GregorianCalendar(year, month, day).getTime();

                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .setView(view)
                .create();
    }

    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
