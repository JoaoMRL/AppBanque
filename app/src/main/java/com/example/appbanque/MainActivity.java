package com.example.appbanque;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button inscription;
    EditText email,password;
    TextView alreadyacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }


        inscription = findViewById(R.id.btn_Inscription);
        alreadyacc = findViewById(R.id.alreadyAcc);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

//        if (!email.getText().toString().equals("") & !password.getText().toString().equals("")){
//            inscription.setEnabled(true);
//            inscription.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
//                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success, update UI with the signed-in user's information
//                                        Log.d("Sc", "createUserWithEmail:success");
//
//
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        Toast.makeText( .this,"Authentication failed.",
//                                                Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
//                }
//            });
//        }
    }
}

