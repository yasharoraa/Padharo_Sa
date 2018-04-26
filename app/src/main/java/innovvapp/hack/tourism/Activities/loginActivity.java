package innovvapp.hack.tourism.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 20-03-2018.
 */

public class loginActivity extends AppCompatActivity {

    private FirebaseAuth mFireBaseAuth;


    private static final int RC_SIGN_IN = 1001;


    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mFireBaseAuth = FirebaseAuth.getInstance();


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (mFireBaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);

                    intent.putExtra("id", mFireBaseAuth.getCurrentUser().getDisplayName());

                    startActivity(intent);
                } else {

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)

                                    .setTheme(R.style.logintheme)

                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),

                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);

                }
            }


        };

    }

    @Override
    protected void onPause() {
        super.onPause();
        mFireBaseAuth.removeAuthStateListener(mAuthStateListener);

    }

    @Override
    protected void onResume(){
        super.onResume();
        mFireBaseAuth.addAuthStateListener(mAuthStateListener);

    }




    }

