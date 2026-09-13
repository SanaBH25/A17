package com.example.usagersapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dao.UsagerAdapter;
import modele.Usager;

public class EditionActivity extends AppCompatActivity {

    private EditText txtNom, txtAge;
    private UsagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edition);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setWidgets();
        adapter = new UsagerAdapter(EditionActivity.this);
    }

    private void setWidgets() {
        txtNom = findViewById(R.id.txtNom);
        txtAge = findViewById(R.id.txtAge);
    }

    public void onRetour(View view) {
        this.finish();
    }

    public void onAjouter(View view) {
        String nom = txtNom.getText().toString();
        int age = Integer.parseInt(txtAge.getText().toString());
        Usager usager = new Usager(age,nom);
        //insertion
        adapter.inserer(usager);
        Toast.makeText(this, "Usager ajouté ", Toast.LENGTH_LONG).show();
    }
}