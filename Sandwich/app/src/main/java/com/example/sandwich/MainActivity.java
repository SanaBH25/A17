package com.example.sandwich;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radGroup;
    private RadioButton radVege, radRouge, radBlanc;
    private CheckBox chkMayo, chkKetchup;
    private Button btnCommander;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setWidgets();
        setListeners();
    }

    private void setListeners() {
        btnCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String options = determinerOptions();
                Toast.makeText(MainActivity.this, options, Toast.LENGTH_LONG).show();
                //android.widget.Toast.makeText(MainActivity.this, options, android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String determinerOptions() {
        StringBuilder sb = new StringBuilder();
        int id = radGroup.getCheckedRadioButtonId();
        if (id == radVege.getId()) {
            sb.append(getString(R.string.v_g_tarien));
        } else if (id == radRouge.getId()) {
            sb.append(getString(R.string.viande_rouge));
        } else if (id == radBlanc.getId()) {
            sb.append(getString(R.string.viande_blanche));
        }

        if (chkMayo.isChecked()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(getString(R.string.mayonnaise));
        }
        if (chkKetchup.isChecked()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(getString(R.string.ketchup));
        }

        return sb.toString();
    }

    private void setWidgets() {
        radGroup = findViewById(R.id.radGroup);
        radVege = findViewById(R.id.radVégé);
        radRouge = findViewById(R.id.radRouge);
        radBlanc = findViewById(R.id.radBlanc);
        chkMayo = findViewById(R.id.chkMayo);
        chkKetchup = findViewById(R.id.chkKetchup);
        btnCommander = findViewById(R.id.btnCommander);
    }
}