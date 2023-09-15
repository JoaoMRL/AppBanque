package com.example.appbanque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class budget_choice_activity extends AppCompatActivity {
    Button btn_Plus,btn_Accueil,btn_Budget,btn_Vacance,btn_Pallier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_choice_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btn_Plus=findViewById(R.id.btn_Plus);
        btn_Accueil=findViewById(R.id.btn_Acceuil);
        btn_Budget=findViewById(R.id.btn_Budget);
        btn_Vacance=findViewById(R.id.btn_Vancance);
        btn_Pallier=findViewById(R.id.btn_Pallier);




        btn_Pallier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PallierActivity.class);
                startActivity(intent);
            }
        });
        btn_Vacance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), budget_vacance_activity.class);
                startActivity(intent);
            }
        });

        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlusActivity.class);
                startActivity(intent);
            }
        });
        btn_Accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccueilActivity.class);
                startActivity(intent);
            }
        });
        btn_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), budget_choice_activity.class);
                startActivity(intent);
            }
        });
    }
}
