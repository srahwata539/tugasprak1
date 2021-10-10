package com.example.a1918131_lukas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Segitiga extends AppCompatActivity {
    EditText etAlas , etTinggi;
    Button button;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        etAlas = findViewById(R.id.alas);
        etTinggi = findViewById(R.id.tinggi);
        tvHasil = findViewById(R.id.hasil);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alas = etAlas.getText().toString().trim();
                String tinggi = etTinggi.getText().toString().trim();
                boolean isEmpty = false;
                boolean isInvalid = false;
                if(TextUtils.isEmpty(alas)){
                    isEmpty=true;
                    etAlas.setError("HEM");
                }
                if(TextUtils.isEmpty(tinggi)){
                    isEmpty=true;
                    etTinggi.setError("HAH");
                }
                Double a = toDouble(alas);
                Double t = toDouble(tinggi);
                if (a==null){
                    isInvalid=true;
                    etAlas.setError("isi ");
                }
                if(t==null){
                    isInvalid=true;
                    etTinggi.setError("angka");
                }

                if(!isEmpty && !isInvalid){
                    double luas = 0.5 * a * t;
                    tvHasil.setText(String.valueOf(luas));
                }
            }
        });
    }
    private Double toDouble(String value){
        try {
            return Double.valueOf(value);
        }catch (NumberFormatException e){
            return null;
        }

    }

}