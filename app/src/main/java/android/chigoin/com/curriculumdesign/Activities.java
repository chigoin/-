package android.chigoin.com.curriculumdesign;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by chigoin on 2017/11/5.
 */

public class Activities extends DataSupport implements Parcelable {
    private String name;
    private String time;
    private String site;
    private String holders;


    public void setName(String name){
        this.name=name;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setSite(String site){
        this.site=site;
    }
    public void setHolders(String holders){
        this.holders=holders;
    }
    public String getName(){
        return name;
    }
    public String getTime(){
        return time;
    }
    public String getSite(){
        return site;
    }
    public String getHolders(){
        return holders;
    }

    @Override
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(site);
        dest.writeString(holders);
    }
    public static final Parcelable.Creator<Activities> CREATOR =new Parcelable.Creator<Activities>(){
        @Override
        public Activities createFromParcel(Parcel source){
            Activities activities=new Activities();
            activities.name=source.readString();
            activities.time=source.readString();
            activities.site=source.readString();
            activities.holders=source.readString();
            return activities;
        }
        @Override
        public Activities[] newArray(int size){
            return new Activities[size];
        }
    };
}
