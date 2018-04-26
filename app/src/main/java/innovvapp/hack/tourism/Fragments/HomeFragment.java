package innovvapp.hack.tourism.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import innovvapp.hack.tourism.Adapters.HomeAdapter;
import innovvapp.hack.tourism.Models.Models;
import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 16-03-2018.
 */

public class HomeFragment extends Fragment {


    @BindView(R.id.card_view)
    RecyclerView hotelsRecyclerView;

    @BindView(R.id.image_upper)
    ImageView upperImageView;

    @BindView(R.id.upper_image_view)
    CardView cardView;

    private HomeAdapter homeAdapter;

    private List<Models> modelsList;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.fragent_home,container,false);



        unbinder = ButterKnife.bind(this,rootView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        modelsList = new ArrayList<>();

        homeAdapter = new HomeAdapter(getContext(),modelsList);

        hotelsRecyclerView.setLayoutManager(mLayoutManager);

        hotelsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        hotelsRecyclerView.addItemDecoration(new GridSpacingItemDecoration(1,dpToPx(10),true));



        upperImageView.setImageResource(R.drawable.padharosa);

        upperImageView.setScaleType(ImageView.ScaleType.FIT_XY);




        hotelsRecyclerView.setAdapter(homeAdapter);

        cardView.setRadius(65);




        prepareList();


        return rootView;


    }

    private void prepareList(){
        Models a = new Models("Hotel","Hotel Marigold",0,true,true,R.drawable.rated_marigold,R.string.igsif);

        modelsList.add(a);

        a = new Models("Restaurant","Casa Bella",0,false,false,R.drawable.rated_casa_bella,R.string.igsif);

        modelsList.add(a);
        a = new Models("Places","Buddha Temple",0,true,true,R.drawable.rated_buddha_temple,R.string.igsif);

        modelsList.add(a);

        a = new Models("Travel","Uber",0,false,false,R.drawable.rated_uber,R.string.igsif);

        modelsList.add(a);








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
