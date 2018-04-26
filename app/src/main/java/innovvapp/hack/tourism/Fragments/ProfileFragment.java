package innovvapp.hack.tourism.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 20-03-2018.
 */

@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment
{

    public String username;


    Unbinder unbinder;

    @BindView(R.id.user_name_text_view)
    TextView UserNameTextView;


    @SuppressLint("ValidFragment")
    public ProfileFragment(String username) {
        this.username = username;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final  View rootView = inflater.inflate(R.layout.profile_layout,container,false);

        unbinder= ButterKnife.bind(this,rootView);


        UserNameTextView.setText(username);

        return rootView;





    }
}
