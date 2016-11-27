package com.devfest.its.its_devfest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.devfest.its.its_devfest.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by schhaiderahmed on 26/11/16.
 */

public class BaseActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ProgressDialog mProgressDialog;


    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }


        mProgressDialog.show();
    }
    private void writeNewUser(String userId, String name) {
        User userDev = new User(name);


        mDatabase.child("users_inst").child(userId).setValue(userDev);
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
    public FirebaseUser getUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }


}
