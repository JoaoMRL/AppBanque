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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AccueilActivity extends AppCompatActivity {
    Button btn_Plus,btn_Accueil,btn_Budget,
            btn_AddDepense,btn_Planning,btn_Graph;
    TextView tv_SeeMore, tv_Total;

    LinearLayout L2;
    LinearLayout ll_Contenu;
    Integer total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        btn_Plus=findViewById(R.id.btn_Plus);
        btn_Accueil=findViewById(R.id.btn_Acceuil);
        btn_Budget=findViewById(R.id.btn_Budget);
        btn_AddDepense=findViewById(R.id.btn_AddDepense);
        btn_Planning=findViewById(R.id.btn_Planning);
        btn_Graph=findViewById(R.id.btn_Graph);

        tv_Total=findViewById(R.id.tv_DepTt);
//        tv_SeeMore= findViewById(R.id.tv_SeeMore);
        ll_Contenu=findViewById(R.id.ll_Contenu);
        L2=findViewById(R.id.l2);

        total = Integer.parseInt(tv_Total.getText().toString()) ;
        db.collection("User")
                        .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()){
                                            for (QueryDocumentSnapshot document : task.getResult()){
                                                LinearLayout elLayout = new LinearLayout(AccueilActivity.this);
                                                elLayout.setOrientation(LinearLayout.HORIZONTAL);
                                                TextView dep = new TextView(AccueilActivity.this);
                                                TextView lab = new TextView(AccueilActivity.this);
                                                TextView pric = new TextView(AccueilActivity.this);
                                                TextView norm = new TextView(AccueilActivity.this);
                                                norm.setText("€");
                                                pric.setText(document.getData().get("prix").toString());
                                                lab.setText(document.getData().get("label").toString());
                                                dep.setText("Dépense :");
                                                elLayout.addView(dep);
                                                elLayout.addView(lab);
                                                elLayout.addView(pric);
                                                elLayout.addView(norm);
                                                L2.addView(elLayout);
                                                total +=Integer.parseInt(document.getData().get("prix").toString());
                                            }
                                            tv_Total.setText(total.toString());
                                        }else {
                                            Toast.makeText(AccueilActivity.this,"Error "+task.getException(),Toast.LENGTH_LONG).show();
                                        }


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
        btn_Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        AccueilActivity.class);
                startActivity(intent);
            }
        });
        btn_AddDepense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        AddDepenseActivity.class);
                startActivity(intent);
            }
        });
        btn_Planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        PlanningActivity.class);
                startActivity(intent);
            }
        });

    }
}
