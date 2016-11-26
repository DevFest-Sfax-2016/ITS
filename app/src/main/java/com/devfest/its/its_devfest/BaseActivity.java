package com.devfest.its.its_devfest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by schhaiderahmed on 26/11/16.
 */

public class BaseActivity extends AppCompatActivity {


    private ProgressDialog mProgressDialog;


    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }


        mProgressDialog.show();
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
