package com.example.usagersapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import dao.UsagerAdapter;
import modele.Usager;

public class ListingActivity extends AppCompatActivity {

    private UsagerAdapter adapter;
    private ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstView = findViewById(R.id.lstView);
        adapter = new UsagerAdapter(ListingActivity.this);
        afficherUsagers();
    }

    private void afficherUsagers() {
        ArrayList<Usager> listing = adapter.lister();
        ArrayAdapter<Usager> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listing);
        lstView.setAdapter(adp);
    }

    public void onRetour(View view) {
        this.finish();
    }
}