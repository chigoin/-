package android.chigoin.com.curriculumdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by chigoin on 2017/10/28.
 */

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {
    private Activities[] activitiesList=new Activities[5];
    private Context mContext;
    private List<Club> mClubList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView clubImage;
        TextView clubName;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            clubImage=(ImageView) view.findViewById(R.id.club_image);
            clubName=(TextView)view.findViewById(R.id.club_name);

        }
    }

    public ClubAdapter(List<Club> clubList){
        mClubList = clubList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item,parent,false);
       final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                Club club=mClubList.get(position);
                Intent intent=new Intent(mContext,ClubActivity.class);

                //putExtra(ClubActivity.CLUB_NAME,club.getName());
                //intent.putExtra(ClubActivity.CLUB_IMAGE_ID,club.getImageId());
                intent.putExtra("activities1",club.getActivities().get(0));
                intent.putExtra("activities2",club.getActivities().get(1));
                intent.putExtra("club_activities",club);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Club club = mClubList.get(position);
        holder.clubName.setText(club.getName());
        Glide.with(mContext).load(club.getImageId()).into(holder.clubImage);
    }

    @Override
    public int getItemCount(){
        return mClubList.size();
    }
}
