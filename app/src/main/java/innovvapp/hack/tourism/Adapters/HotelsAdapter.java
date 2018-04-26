package innovvapp.hack.tourism.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.willy.ratingbar.ScaleRatingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovvapp.hack.tourism.Activities.ActivityFullScreen;
import innovvapp.hack.tourism.Models.SecondModel;
import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 17-03-2018.
 */

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.ViewHolder>  {
    private Context mContext;

    SecondModel newlistModel;


    private List<SecondModel> secondList;

    private Boolean ifSaved;

    private int FragmentType;




    @Override
    public HotelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card,parent,false);

        return new HotelsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HotelsAdapter.ViewHolder holder, int position) {
        newlistModel = secondList.get(position);

        ifSaved = newlistModel.isSaved();

        holder.NameTextView.setText(newlistModel.getName());

        holder.firstRatingBar.setRating(newlistModel.getFirstStar());

        holder.secondRatingBar.setRating(newlistModel.getSecondStar());

        holder.thirdRatingBar.setRating(newlistModel.getThirdStar());

        holder.fourthRatingBar.setRating(newlistModel.getFourthStar());

        holder.overRatingTextView.setText(String.valueOf(newlistModel.getTotalRatings()));

        if (0<=newlistModel.getTotalRatings()&newlistModel.getTotalRatings()<=2){
            holder.overRatingTextView.setTextColor(mContext.getResources().getColor(R.color.red_color));
        }else if (2.1<=newlistModel.getTotalRatings()&newlistModel.getTotalRatings()<=4){
            holder.overRatingTextView.setTextColor(mContext.getResources().getColor(R.color.yellow));
        }else {
            holder.overRatingTextView.setTextColor(mContext.getResources().getColor(R.color.green));
        }

        if (newlistModel.isOpen()){

            holder.OpenImageView.setImageResource(R.drawable.ic_action_open);
            holder.ImageOpenTextView.setText(R.string.title_open);
            holder.ImageOpenTextView.setTextColor(mContext.getResources().getColor(R.color.green));

        }else {
            holder.OpenImageView.setImageResource(R.drawable.ic_action_closed_red);
            holder.ImageOpenTextView.setText(R.string.title_closed);
            holder.ImageOpenTextView.setTextColor(mContext.getResources().getColor(R.color.red_color));
        }

        if (newlistModel.isSaved()){
            holder.SaveImageView.setImageResource(R.drawable.ic_action_saved_sand);
            holder.SaveImageTextView.setText(R.string.title_saved);
        }else {
            holder.SaveImageView.setImageResource(R.drawable.ic_action_save_sand);
            holder.SaveImageTextView.setText(R.string.title_save);
        }
        holder.HotelImageView.setImageResource(newlistModel.getImageResource());
    }


    @Override
    public int getItemCount() {
        return secondList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.top_rated_text_view)
        TextView TopRatedTextView;

        @BindView(R.id.recom_text_view)
        TextView RecomTextView;

        @BindView(R.id.name_text_view)
        TextView NameTextView;

        @BindView(R.id.image_open)
        ImageView OpenImageView;

        @BindView(R.id.image_open_text_view)
        TextView ImageOpenTextView;


        @BindView(R.id.save_image_text_view)
        TextView SaveImageTextView;

        @BindView(R.id.image_save)
        ImageView SaveImageView;

        @BindView(R.id.hotel_image)
        ImageView HotelImageView;

        @BindView(R.id.simpleRatingBar_first)
        ScaleRatingBar firstRatingBar;

        @BindView(R.id.simpleRatingBar_second)
        ScaleRatingBar secondRatingBar;

        @BindView(R.id.simpleRatingBar_third)
        ScaleRatingBar thirdRatingBar;

        @BindView(R.id.simpleRatingBar_fourth)
        ScaleRatingBar fourthRatingBar;

        @BindView(R.id.first_rating_text_view)
        TextView firstRatingTextView;

        @BindView(R.id.second_rating_text_view)
        TextView secondRatingTextView;

        @BindView(R.id.third_rating_text_view)
        TextView thirdRatingTextView;

        @BindView(R.id.image_call)
        ImageView CallImageView;

        @BindView(R.id.image_dir)
        ImageView DirectionImageView;

        @BindView(R.id.image_share)
        ImageView ShareImageView;

        @BindView(R.id.fourth_rating_text_view)
        TextView fourthRatingTextView;

        @BindView(R.id.over_ratings)
        TextView overRatingTextView;

        @BindView(R.id.full_card_view)
        CardView cardView;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            CallImageView.setImageResource(R.drawable.ic_action_call_sand);
            SaveImageView.setOnClickListener(this);
            CallImageView.setOnClickListener(this);
            SaveImageView.setOnClickListener(this);
            ShareImageView.setImageResource(R.drawable.ic_action_share_sand);
            DirectionImageView.setImageResource(R.drawable.directions_sand);

            if (FragmentType == 2){
                firstRatingTextView.setText(R.string.title_driving);
                secondRatingTextView.setText(R.string.title_service_travels);
                thirdRatingTextView.setText(R.string.title_facilities);
                fourthRatingTextView.setText(R.string.title_behaviour);

            }else if (FragmentType==1){
                firstRatingTextView.setText(R.string.title_food);
                secondRatingTextView.setText(R.string.title_facilities_hotel);
                thirdRatingTextView.setText(R.string.title_accomodation);
                fourthRatingTextView.setText(R.string.title_staff_behaviour_hotel);
            }else {
            firstRatingTextView.setText(R.string.title_service);
            secondRatingTextView.setText(R.string.title_view_point);
            thirdRatingTextView.setText(R.string.title_cleanliness);
            fourthRatingTextView.setText(R.string.title_staff_behaviour);







            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ActivityFullScreen.class);


                    mContext.startActivity(intent);
                }
            });



        }

        @Override
        public void onClick(View v) {

            int Position = getAdapterPosition();

            newlistModel = secondList.get(Position);

            if (v.getId()==SaveImageView.getId()){


                if (newlistModel.isSaved()) {
                    newlistModel.setSaved(false);
                    notifyDataSetChanged();
                } else {
                    newlistModel.setSaved(true);
                    notifyDataSetChanged();
                }


            }else if (v.getId() == CallImageView.getId()){

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+newlistModel.getNumber()));
                mContext.startActivity(intent);

            }





        }
    }



    public HotelsAdapter(Context mContext, List<SecondModel> secondList, int fragmentType) {
        this.mContext = mContext;
        this.secondList = secondList;
        FragmentType = fragmentType;
    }
}
