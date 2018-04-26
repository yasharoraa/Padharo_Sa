package innovvapp.hack.tourism.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 28-03-2018.
 */

public class startActvity extends AppCompatActivity {

    ImageView startImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_in_layout);


        startImageView = (ImageView) findViewById(R.id.image_view_start);

        startImageView.setImageResource(R.drawable.welcome_screen);


        new CountDownTimer(300, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(startActvity.this,loginActivity.class);

                startActivity(intent);

            }
        }.start();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
