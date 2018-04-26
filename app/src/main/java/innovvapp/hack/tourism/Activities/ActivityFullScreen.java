package innovvapp.hack.tourism.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.willy.ratingbar.ScaleRatingBar;

import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 20-03-2018.
 */

public class ActivityFullScreen  extends AppCompatActivity {


    ScaleRatingBar fullScreenRatingBar;

    EditText fullScreenEditText;

    Button fullScreenButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_screen);

        fullScreenRatingBar = (ScaleRatingBar) findViewById(R.id.top_rating_bar);

        fullScreenEditText = (EditText) findViewById(R.id.edit_text_fullscreen);

        fullScreenButton= (Button) findViewById(R.id.button);




        fullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityFullScreen.this,"Thanks for your review",Toast.LENGTH_SHORT).show();
                fullScreenRatingBar.setRating(0);

                fullScreenEditText.setText("");
            }
        });




    }
}
