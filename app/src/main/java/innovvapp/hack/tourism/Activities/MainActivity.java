package innovvapp.hack.tourism.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import innovvapp.hack.tourism.Fragments.HomeFragment;
import innovvapp.hack.tourism.Fragments.HotelFragment;
import innovvapp.hack.tourism.Fragments.ProfileFragment;
import innovvapp.hack.tourism.R;
import innovvapp.hack.tourism.Utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {


   Toolbar toolbar;

    private TextView mTextMessage;

    private String email;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    HomeFragment homeFragment = new HomeFragment();

                    changeMainFragment(MainActivity.this,homeFragment);


                    toolbar.setTitle(R.string.title_home);



                    return true;
                case R.id.navigation_hotels:


                    HotelFragment hotelFragment = new HotelFragment(1);

                    changeMainFragment(MainActivity.this,hotelFragment);

                    toolbar.setTitle(R.string.title_hotels_toolbar);









                    return true;
                case R.id.navigation_travel:

                    HotelFragment travelFragment = new HotelFragment(2);

                    changeMainFragment(MainActivity.this,travelFragment);

                    toolbar.setTitle(R.string.title_travel);



                    return true;
                case R.id.navigation_places:

                    HotelFragment placesFragment = new HotelFragment(3);

                    changeMainFragment(MainActivity.this,placesFragment);

                    toolbar.setTitle(R.string.title_places);





                    return true;
                case R.id.navigation_profile:

                    ProfileFragment profileFragment = new ProfileFragment(email);


                    changeMainFragment(MainActivity.this,profileFragment);


                    toolbar.setTitle(R.string.title_profile);



                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        mTextMessage = (TextView) findViewById(R.id.message);

        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        HomeFragment homeFragment = new HomeFragment();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                email = getResources().getString(R.string.user_name);
            } else {
                email = extras.getString("id");
            }
        } else {
            email = (String) savedInstanceState.getSerializable("id");
        }

        changeMainFragment(MainActivity.this, homeFragment);
        toolbar.setTitle(R.string.title_home);

        CardView cardView = (CardView) findViewById(R.id.card_view);

    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

    public static void changeMainFragment(FragmentActivity fragmentActivity, Fragment fragment){
        fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }



}
