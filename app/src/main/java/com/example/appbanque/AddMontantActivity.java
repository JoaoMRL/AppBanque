package com.example.appbanque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class AddMontantActivity extends AppCompatActivity {
    Button btn_Plus,btn_Accueil,btn_Budget,btn_add;
    EditText label, prix;
    Integer i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montant_add_activity);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btn_Plus=findViewById(R.id.btn_Plus);
        btn_Accueil=findViewById(R.id.btn_Acceuil);
        btn_Budget=findViewById(R.id.btn_Budget);
        btn_add=findViewById(R.id.btn_addMontant);

        label=findViewById(R.id.label);
        prix=findViewById(R.id.prix);





        btn_add.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           String getLabel= label.getText().toString();
                                           String getprix=prix.getText().toString();


                                           HashMap<String,Object> hashMap = new HashMap<>();
                                           hashMap.put("label",getLabel);
                                           hashMap.put("prix",getprix);


                                           FirebaseFirestore.getInstance().collection("UserVancance")
                                                   .document("Montant"+i)
                                                   .set(hashMap)
                                                   .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                       @Override
                                                       public void onSuccess(Void unused) {
                                                           Toast.makeText(AddMontantActivity.this,"Data saved Successfully",Toast.LENGTH_LONG).show();
                                                       }
                                                   })
                                                   .addOnFailureListener(new OnFailureListener() {
                                                       @Override
                                                       public void onFailure(@NonNull Exception e) {
                                                           Toast.makeText(AddMontantActivity.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
                                                       }
                                                   });
                                           i++;
                                       }

                                   }
        );

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
