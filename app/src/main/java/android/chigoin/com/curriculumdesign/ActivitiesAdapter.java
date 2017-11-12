package android.chigoin.com.curriculumdesign;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chigoin on 2017/10/31.
 */

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mActivityList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView clubActivity;

        public ViewHolder(View view){
            super(view);
            cardView =(CardView) view;
            clubActivity=(TextView) view.findViewById(R.id.activity);
        }
    }

    public ActivitiesAdapter(List<String> activityList){
        mActivityList=activityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_avtivities_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        String activity=mActivityList.get(position);
        holder.clubActivity.setText(activity);
    }

    @Override
    public int getItemCount(){
        return mActivityList.size();
    }
}
