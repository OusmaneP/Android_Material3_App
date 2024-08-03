package com.podosoft.myapptestmaterial.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;
import com.podosoft.myapptestmaterial.R;
import com.podosoft.myapptestmaterial.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BadgeDrawable badge = binding.bottomNavigation.getOrCreateBadge(R.id.navigation_notifications);
        badge.setVisible(true);
        badge.setNumber(9999);

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                if (item.getItemId() == R.id.navigation_dashboard){
                    Toast.makeText(MainActivity3.this, "Dashboard ✅", Toast.LENGTH_SHORT).show();
                    BadgeDrawable badgeDrawable = binding.bottomNavigation.getBadge(R.id.navigation_notifications);
                    if (badgeDrawable != null) {
                        binding.bottomNavigation.removeBadge(R.id.navigation_notifications);
                    }
                }
                return false;
            }
        });
    }
}