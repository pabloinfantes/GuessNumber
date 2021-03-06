package com.example.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.guessnumber.R;
import com.example.guessnumber.databinding.ActivityEndPlayBinding;


/**
 * Esta clase es la final y muestra al jugador si ha acertado el número de intentos que ha consumido y si no ha acertado el número final.
 * @author pablo
 * @version 1.0
 */
public class EndPlayActivity extends AppCompatActivity {
    ActivityEndPlayBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        boolean ganaste = bundle.getBoolean("HaAcertado");
        int numIntentos = bundle.getInt("NumeroIntentos");
        int numGanador = bundle.getInt("NumeroGanador");
        if (ganaste){
            binding.tvGanaste.setVisibility(View.VISIBLE);
            binding.tvGanaste.setText(binding.tvGanaste.getText()+ getString(R.string.tvQuedaban) + String.valueOf(numIntentos) + R.string.Intentos);
        }else{
            binding.tvPerdiste.setVisibility(View.VISIBLE);
            binding.tvPerdiste.setText(binding.tvPerdiste.getText()+ getString(R.string.tvGanador) + String.valueOf(numGanador));
        }


    }


}