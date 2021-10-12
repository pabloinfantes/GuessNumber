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

/**
 * Esta clase hay binding entre el xml y la clase que maneja un campo EditText donde el usuario introduce el número que piensa que es, una vez pulse sobre el
 * botón comprueba y saldrá un mensaje diciendo si es mayor o menor en un campo TextView y la posibilidad de volver a
 * intentarlo si no ha superado el número de intentos mediante otro Button que borra el mensaje y el número anteriormente introducido.
 * @author pablo
 * @version 1.0
 */
public class PlayActivity extends AppCompatActivity {

    ActivityPlayBinding binding;
    Random rnd = new Random();
    int numeroGanador = 1 + rnd.nextInt(101);
    int intentosMax = 0;
    boolean haAcertado = false;
    String mensaje1 = "Los campos no pueden estar vacíos";
    String mensaje = "El valor del campo intentos debe ser un numero entero positivo";

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
        switch (view.getId()) {
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
        Toast.makeText(PlayActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void comprobar() {

        if (!TextUtils.isEmpty(binding.edNumeroIntentado.getText())){
            if (TextUtils.isDigitsOnly(binding.edNumeroIntentado.getText())) {
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
            } else {
                Toast.makeText(PlayActivity.this, R.string.tvNumEnteros, Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(PlayActivity.this, R.string.tvVacios, Toast.LENGTH_SHORT).show();

        }


    }

    private void activityFinal() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("HaAcertado", haAcertado);
        bundle.putInt("NumeroIntentos", intentosMax);
        bundle.putInt("NumeroGanador", numeroGanador);
        Intent intent = new Intent(this, EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}