package com.podosoft.myapptestmaterial.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.podosoft.myapptestmaterial.R;
import com.podosoft.myapptestmaterial.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.standardBottomSheet.getVisibility() == View.VISIBLE){
                    binding.standardBottomSheet.setVisibility(View.INVISIBLE);
                }
                else {
                    binding.standardBottomSheet.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}