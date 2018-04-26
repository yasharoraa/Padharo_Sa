package innovvapp.hack.tourism.Fragments;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import innovvapp.hack.tourism.Adapters.HotelsAdapter;
import innovvapp.hack.tourism.Models.SecondModel;
import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 17-03-2018.
 */
@SuppressLint("ValidFragment")
public class HotelFragment extends Fragment {


    @BindView(R.id.card_view)
    RecyclerView hotelsRecyclerView;

    @BindView(R.id.image_upper)
    ImageView upperImageView;

    @BindView(R.id.upper_text_view)
    TextView upperTextView;

    private HotelsAdapter hotelsAdapter;

    private List<SecondModel> modelsList;

    Unbinder unbinder;


    private int FragmentType;

    @SuppressLint("ValidFragment")
    public HotelFragment(int fragmentType) {
        FragmentType = fragmentType;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.fragent_home,container,false);




        unbinder = ButterKnife.bind(this,rootView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        modelsList = new ArrayList<>();

        hotelsAdapter = new HotelsAdapter(getContext(),modelsList,FragmentType);

        hotelsRecyclerView.setLayoutManager(mLayoutManager);

        hotelsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        hotelsRecyclerView.addItemDecoration(new GridSpacingItemDecoration(1,dpToPx(10),true));

        hotelsRecyclerView.setAdapter(hotelsAdapter);

        if (FragmentType == 1){
            upperImageView.setImageResource(R.drawable.hotel);
            upperTextView.setText(R.string.title_hotels_toolbar);
        }else if (FragmentType == 2){
            upperImageView.setImageResource(R.drawable.bus);
            upperTextView.setText(R.string.title_travel);

        }else {
            upperImageView.setImageResource(R.drawable.mahal);
            upperTextView.setText(R.string.title_places);

        }

        prepareList();

        return rootView;
    }

    private void prepareList(){

        if (FragmentType == 1){

            SecondModel a = new SecondModel("Hotel Sunshine",true,false,R.drawable.rated_sunshine,2,3,1,5,R.string.igsif,2.5);

            modelsList.add(a);

            a = new SecondModel("Hotel Marigold",true,false,R.drawable.rated_marigold,2,3,1,5,R.string.igsif,4.1);

            modelsList.add(a);
            a = new SecondModel("Hotel Casa Bella",false,false,R.drawable.rated_casa_bella,2,3,1,5,R.string.igsif,1.0);

            modelsList.add(a);


        }else if (FragmentType == 2){

            SecondModel a = new SecondModel("Ola",true,false,R.drawable.rated_ola,2,3,1,5,R.string.igsif,2.5);

            modelsList.add(a);

            a = new SecondModel("Uber",true,false,R.drawable.rated_uber,2,3,1,5,R.string.igsif,4.1);

            modelsList.add(a);
            a = new SecondModel("Jugnoo",false,false,R.drawable.rated_jugnoo,2,3,1,5,R.string.igsif,1.0);

            modelsList.add(a);




        }else if (FragmentType == 3){

            SecondModel a = new SecondModel("Hawa Mahal",true,false,R.drawable.rated_hawamahal,2,3,1,5,R.string.igsif,2.5);

            modelsList.add(a);

            a = new SecondModel("City Palace",true,false,R.drawable.rated_city_palace,2,3,1,5,R.string.igsif,4.1);

            modelsList.add(a);
            a = new SecondModel("Buddha Temple",false,false,R.drawable.rated_buddha_temple,2,3,1,5,R.string.igsif,1.0);

            modelsList.add(a);


        }




    }





    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }





    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
