package com.podosoft.myapptestmaterial.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupMenu;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.podosoft.myapptestmaterial.R;
import com.podosoft.myapptestmaterial.databinding.ActivityMain7Binding;

public class MainActivity7 extends AppCompatActivity {

    ActivityMain7Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.extendedFab.isExtended()) {
                    binding.extendedFab.shrink();
                }
                else {
                    binding.extendedFab.extend();
                }
            }
        });

        binding.extendedFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v, R.menu.popup_menu);
            }
        });

        binding.btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(binding.btnSnack, "Snack bar clicked", BaseTransientBottomBar.LENGTH_LONG)
                        .setAnchorView(binding.fab)
                        .setAction("✅", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });

        binding.btnTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSystem24Hour = DateFormat.is24HourFormat(MainActivity7.this);

                MaterialTimePicker.Builder picker = new MaterialTimePicker.Builder();
                picker
                        .setTimeFormat(isSystem24Hour ? TimeFormat.CLOCK_24H : TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(10)
                        .setTitleText("Select Appointment time")
                        .build()
                        .show(getSupportFragmentManager(), "tag");



            }
        });


    }

    private void showMenu(View v, int menuRes) {
        Context context = v.getContext();
        PopupMenu popup = new PopupMenu(context, v);
        popup.getMenuInflater().inflate(menuRes, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        popup.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu popupMenu) {
                // Respond to popup being dismissed.
            }
        });

        // Show the popup menu.
        popup.show();
    }
}