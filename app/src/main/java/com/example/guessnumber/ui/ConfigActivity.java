package com.example.guessnumber.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.guessnumber.R;
import com.example.guessnumber.data.model.Message;
import com.example.guessnumber.databinding.ActivityConfigBinding;

public class ConfigActivity extends AppCompatActivity {

    ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public void onClickButton(View view) {
        switch (view.getId()){
            case R.id.btnJugar:
                jugar();
                break;
        }
    }

    private void showMessage(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void jugar() {
        if (!TextUtils.isEmpty(binding.edName.getText()) && !TextUtils.isEmpty(binding.edIntento.getText())) {
            if (TextUtils.isDigitsOnly(binding.edIntento.getText())) {
                Bundle bundle = new Bundle();
                Message message = new Message();
                message.setNombre(binding.edName.getText().toString());
                message.setIntento(Integer.parseInt(binding.edIntento.getText().toString()));
                bundle.putSerializable("message", message);

                Intent intent = new Intent(this, PlayActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                showMessage("El valor del campo intentos debe ser un numero entero positivo");
            }
        } else {
            showMessage("Los campos no pueden estar vacíos");
        }
    }



}