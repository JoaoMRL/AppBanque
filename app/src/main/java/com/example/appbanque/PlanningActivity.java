package com.example.appbanque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlanningActivity extends AppCompatActivity {
    Button btn_Plus,btn_Accueil,btn_Budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planning_activity);
    }
    @Override
    protected void onStart() {
        super.onStart();

        btn_Plus=findViewById(R.id.btn_Plus);
        btn_Accueil=findViewById(R.id.btn_Acceuil);
        btn_Budget=findViewById(R.id.btn_Budget);


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
