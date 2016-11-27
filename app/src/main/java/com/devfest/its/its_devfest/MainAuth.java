package com.devfest.its.its_devfest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devfest.its.its_devfest.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainAuth extends BaseActivity implements View.OnClickListener{
    Button dev, ste;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    private FirebaseAuth.AuthStateListener mAuthListener;


    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mSignInButton;
    private Button mSignUpButton;
    private String TAG="Loginste";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_auth);
        dev = (Button) findViewById(R.id.button_dev);
        ste = (Button) findViewById(R.id.button_ste);

        //action btn

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainAuth.this, LoginDev.class));
                finish();
            }
        });

        //ste

        initFirebase();

        ste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainAuth.this, Loginste.class));
                finish();
            }
        });


       // initView();
    }


    private void initView() {
        // Views
        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);
        mSignInButton = (Button) findViewById(R.id.button_sign_in);
        mSignUpButton = (Button) findViewById(R.id.button_sign_up);


        // Click listeners
        /*mSignInButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);*/
    }
    private void writeNewUser(String userId, String name) {
        User userDev = new User(name);


        mDatabase.child("users_inst").child(userId).setValue(userDev);
    }
    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }
    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());


        // Write new user
        writeNewUser(user.getUid(), username);


        // Go to MainActivity
        startActivity(new Intent(MainAuth.this, HomeActivity.class));
        finish();
    }

    private void initFirebase() {


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    onAuthSuccess(mAuth.getCurrentUser());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onClick(View view) {

    }

}