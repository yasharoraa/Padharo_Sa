package innovvapp.hack.tourism.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
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
import innovvapp.hack.tourism.Models.Models;
import innovvapp.hack.tourism.R;

/**
 * Created by Yash Arora on 15-03-2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


    private Context mContext;

    Models listModel;


    private List<Models> modelsList;

    private Boolean ifSaved;

    View.OnClickListener onClickListener;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card,parent,false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       listModel = modelsList.get(position);


    ifSaved = listModel.isSaved();

    holder.TopRatedTextView.setText("Top Rated "+listModel.getType());

    holder.RecomTextView.setText("Recommended "+listModel.getType()+" for you");

    holder.NameTextView.setText(listModel.getName());

    if (listModel.isOpen()){

        holder.OpenImageView.setImageResource(R.drawable.ic_action_open);
        holder.ImageOpenTextView.setText(R.string.title_open);
        holder.ImageOpenTextView.setTextColor(mContext.getResources().getColor(R.color.green));

        }else {
        holder.OpenImageView.setImageResource(R.drawable.ic_action_closed_red);
        holder.ImageOpenTextView.setText(R.string.title_closed);
        holder.ImageOpenTextView.setTextColor(mContext.getResources().getColor(R.color.red_color));
    }

    if (listModel.isSaved()){
        holder.SaveImageView.setImageResource(R.drawable.ic_action_saved_sand);
        holder.SaveImageTextView.setText(R.string.title_saved);
    }else {
        holder.SaveImageView.setImageResource(R.drawable.ic_action_save_sand);
        holder.SaveImageTextView.setText(R.string.title_save);
    }
    holder.HotelImageView.setImageResource(listModel.getImageResource());
    }


    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.simpleRatingBar)
        ScaleRatingBar SingleViewRatingBar;

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


        @BindView(R.id.image_call)
        ImageView CallImageView;




        @BindView(R.id.multiple_ratings_layout_container)
        ConstraintLayout multipleViewRatingBar;

        @BindView(R.id.over_ratings)
        TextView totalRatingsTextView;

        @BindView(R.id.image_share)
        ImageView shareImageView;

        @BindView(R.id.image_dir)
        ImageView directionImageView;

        @BindView(R.id.full_card_view)
        CardView cardView;





        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            CallImageView.setImageResource(R.drawable.ic_action_call_sand);
            SaveImageView.setOnClickListener(this);
            CallImageView.setOnClickListener(this);
            TopRatedTextView.setVisibility(View.VISIBLE);
            RecomTextView.setVisibility(View.VISIBLE);
            SingleViewRatingBar.setVisibility(View.VISIBLE);
            multipleViewRatingBar.setVisibility(View.GONE);
            totalRatingsTextView.setVisibility(View.GONE);
            shareImageView.setImageResource(R.drawable.ic_action_share_sand);
            directionImageView.setImageResource(R.drawable.directions_sand);

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

            listModel = modelsList.get(Position);

            if (v.getId()==SaveImageView.getId()){


                if (listModel.isSaved()) {
                    listModel.setSaved(false);
                    notifyDataSetChanged();
                } else {
                    listModel.setSaved(true);
                    notifyDataSetChanged();
                }


            }else if (v.getId() == CallImageView.getId()){

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+listModel.getNumber()));
                mContext.startActivity(intent);

            }

        }

    }

    public HomeAdapter(Context mContext, List<Models> modelsList) {
        this.mContext = mContext;
        this.modelsList = modelsList;
    }


}
