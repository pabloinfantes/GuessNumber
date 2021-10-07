package com.example.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.guessnumber.R;
import com.example.guessnumber.data.model.Message;
import com.example.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    ActivityPlayBinding binding;
    Random rnd = new Random();
    int numeroGanador = 1+ rnd.nextInt(101);
    int intentosMax = 0;
    boolean haAcertado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Message message = (Message) bundle.getSerializable("message");
        intentosMax = message.getIntento();
    }

    public void onClickButtonPlay(View view) {
        switch (view.getId()){
            case R.id.btComprobar:
                comprobar();
                break;
            case R.id.btBorrar:
                borrar();
                break;
        }
    }

    private void borrar() {
        binding.edNumeroIntentado.setText("");
        binding.tvMayor.setVisibility(View.INVISIBLE);
        binding.tvMenor.setVisibility(View.INVISIBLE);

    }
    private void showMessage(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    private void comprobar() {
        if (TextUtils.isEmpty(binding.edNumeroIntentado.getText()) && TextUtils.isDigitsOnly(binding.edNumeroIntentado.getText())){
        showMessage("El campo numero no puede estar vacio y tiene que ser un numero entero positivo");
        }


        int numeroIntentado = Integer.parseInt(binding.edNumeroIntentado.getText().toString());

        if (numeroIntentado == numeroGanador) {
            haAcertado = true;
            activityFinal();

        } else {
            intentosMax--;
            if (intentosMax == 0) {
            activityFinal();
            return;

            }

            if (numeroIntentado < numeroGanador) {
                binding.tvMayor.setVisibility(View.VISIBLE);

            } else {
                binding.tvMenor.setVisibility(View.VISIBLE);

            }


        }

    }

    private void activityFinal() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("HaAcertado",haAcertado);
        bundle.putInt("NumeroIntentos",intentosMax);
        bundle.putInt("NumeroGanador",numeroGanador);
        Intent intent = new Intent(this,EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}