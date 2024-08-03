package com.podosoft.myapptestmaterial.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.podosoft.myapptestmaterial.R;
import com.podosoft.myapptestmaterial.databinding.ActivityMain5Binding;

public class MainActivity5 extends AppCompatActivity {

    ActivityMain5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                binding.card.setChecked(true);
                return true;
            }
        });



    }
}