package com.example.imcintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import utils.Utilitaire;

public class MainActivity extends AppCompatActivity {

    private EditText txtPoids;
    private EditText txtTaille;
    private Button btnCalculer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnCaluler), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setWidgets();
        setListeners();
    }

    private void setListeners() {
        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double poids = Double.parseDouble( txtPoids.getText().toString());
                double taille = Double.parseDouble( txtTaille.getText().toString());
                double imc = utils.Utilitaire.calculerIMC(poids, taille);
                Toast.makeText(MainActivity.this, "Votre IMC est : " + imc, Toast.LENGTH_LONG).show();
                // appelle resultat
                Intent intent = new Intent(MainActivity.this, ResultatActivity.class);
                intent.putExtra("imc", imc);
                startActivity(intent);
            }
        });
    }
    private void setWidgets() {
        txtPoids = findViewById(R.id.txtPoids);
        txtTaille = findViewById(R.id.txtTaille);
        btnCalculer = findViewById(R.id.btnCalculer);
    }





}