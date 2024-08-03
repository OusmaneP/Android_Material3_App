package com.podosoft.myapptestmaterial.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.SnapHelper;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.podosoft.myapptestmaterial.CarouselAdapter;
import com.podosoft.myapptestmaterial.MainActivity;
import com.podosoft.myapptestmaterial.R;
import com.podosoft.myapptestmaterial.databinding.ActivityMain6Binding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MainActivity6 extends AppCompatActivity {

    ActivityMain6Binding binding;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain6Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Drawable> list = new ArrayList<>();
        list.add(getResources().getDrawable(R.drawable.house));
        list.add(getResources().getDrawable(R.drawable.computer));
        list.add(getResources().getDrawable(R.drawable.anothercomputer));
        list.add(getResources().getDrawable(R.drawable.house));


        CarouselAdapter adapter = new CarouselAdapter(list, MainActivity6.this);
        CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager();
        binding.carouselRecyclerView.setLayoutManager(carouselLayoutManager);
        binding.carouselRecyclerView.setAdapter(adapter);

        binding.datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Build constraints.
                CalendarConstraints constraints = new CalendarConstraints.Builder()
                        .setValidator(DateValidatorPointBackward.now())
                        .build();

                MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("My Date Pick")
                        .setCalendarConstraints(constraints)
                        .build()
                        ;

                datePicker.show(getSupportFragmentManager(), "tag");

                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        Date date = new Date(datePicker.getSelection());

                        Toast.makeText(MainActivity6.this, date.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.dateRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long today = MaterialDatePicker.todayInUtcMilliseconds();

                // Create a Calendar instance and set it to UTC timezone
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                calendar.setTimeInMillis(today);

                // Set the calendar's month to January
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                long janThisYear = calendar.getTimeInMillis();

                // Set the calendar's month to December
                calendar.setTimeInMillis(today);
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                long decThisYear = calendar.getTimeInMillis();

                // Build constraints.
                CalendarConstraints constraints = new CalendarConstraints.Builder()
                        .setStart(janThisYear)
                        .setEnd(decThisYear)
                        .build();

                MaterialDatePicker<Pair<Long, Long>> dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
                        .setTitleText("Select dates")
                        .setCalendarConstraints(constraints)
                        .build();

                dateRangePicker.show(getSupportFragmentManager(), "tag");
            }
        });

        binding.alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(MainActivity6.this);
                dialogBuilder.setTitle("Dialog Title")
                        .setMessage("The alert dialog builder is used to show content that require attention over all activities already opened")
                        .setNeutralButton("Cantcel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }
}