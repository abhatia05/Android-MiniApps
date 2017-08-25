package com.example.ashishbhatia.registeractivityusingfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername,mEmail,mPassword;

    private static final String TAG = "LoginTask";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.UserName);
        mEmail = (EditText) findViewById(R.id.Email);
        mPassword = (EditText) findViewById(R.id.Password);

        mAuth = FirebaseAuth.getInstance();


    }


    public void createAccount(String Email,String Password){
        if ((!TextUtils.isEmpty(Email)) && (!TextUtils.isEmpty(Password))) {
            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG,"Create UserName with Email");
                    if(task.isSuccessful()){
                        Log.d(TAG,"Success");
                    }

                    else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "User Add Operation is Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    public void Login(View view) {

        String Email = mEmail.getText().toString().trim();
        String Password = mPassword.getText().toString().trim();


        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    String name = user.getDisplayName();

                    Toast.makeText(MainActivity.this, "User ID "+ name,
                            Toast.LENGTH_SHORT).show();

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Register(View view) {
        String Username = mUsername.getText().toString().trim();
        String Email = mEmail.getText().toString().trim();
        String Password = mPassword.getText().toString().trim();

        createAccount(Email,Password);

    }
}
