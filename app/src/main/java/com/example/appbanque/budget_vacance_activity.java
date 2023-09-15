package com.example.appbanque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class budget_vacance_activity extends AppCompatActivity {
    Button btn_Plus,btn_Accueil,btn_Budget,btn_AddMontant;
    LinearLayout L2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_vacance_activity);
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        btn_Plus=findViewById(R.id.btn_Plus);
        btn_Accueil=findViewById(R.id.btn_Acceuil);
        btn_Budget=findViewById(R.id.btn_Budget);
        btn_AddMontant=findViewById(R.id.btn_AddMontante);
        L2=findViewById(R.id.l2);

        db.collection("UserVacance")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                LinearLayout elLayout = new LinearLayout(budget_vacance_activity.this);
                                elLayout.setOrientation(LinearLayout.HORIZONTAL);
                                TextView dep = new TextView(budget_vacance_activity.this);
                                TextView lab = new TextView(budget_vacance_activity.this);
                                TextView pric = new TextView(budget_vacance_activity.this);
                                TextView norm = new TextView(budget_vacance_activity.this);
                                norm.setText("€");
                                pric.setText(document.getData().get("prix").toString());
                                lab.setText(document.getData().get("label").toString());
                                dep.setText("Montant :");
                                elLayout.addView(dep);
                                elLayout.addView(lab);
                                elLayout.addView(pric);
                                elLayout.addView(norm);
                                L2.addView(elLayout);

                            }
                        }else {
                            Toast.makeText(budget_vacance_activity.this,"Error "+task.getException(),Toast.LENGTH_LONG).show();
                        }


                    }
                });
        btn_AddMontant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMontantActivity.class);
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
