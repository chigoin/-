package android.chigoin.com.curriculumdesign;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chigoin on 2017/10/23.
        */

public class Club extends DataSupport implements Parcelable{
    private int imageId;
    private String name;
    private String sinceTime;
    private String captain;
    private String tel;
    private String mail;
    private String member;
    private ArrayList<Activities> activities = new ArrayList<>();
    private String intro;
    private String information;

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(name);
        dest.writeInt(imageId);
        dest.writeString(intro);
        //dest.writeStringList(activities);
    }

    public static final Parcelable.Creator<Club> CREATOR =new Parcelable.Creator<Club>(){
        @Override
        public Club createFromParcel(Parcel source){
        Club club=new Club(null,0);
        club.name=source.readString();
        club.imageId=source.readInt();
        club.intro=source.readString();
            return club;
        }

        @Override
        public Club[] newArray(int size){
            return new Club[size];
        }
    };

    public Club(String name,int imageId){this.imageId=imageId;this.name=name;}
    public void setSinceTime(String sinceTime){
        this.sinceTime=sinceTime;
    }
    public void setCaptain(String captain){
        this.captain=captain;
    }
    public void setTel(String contact){
        this.tel=tel;
    }
    public void setMail(String mail){this.mail=mail;}
    public void setInformation(String information){
        this.information=information;
    }
    public void setMember(String member){this.member=member;}
    public void setIntro(String intro){this.intro=intro;}
    public void addActivity(Activities activity){
        this.activities.add(activity);
    }


    public int getImageId(){return imageId;}
    public String getName(){return name;}
    public String getSinceTime(){
        return sinceTime;
    }
    public String getCaptain(){
        return captain;
    }
    public String getTel(){
        return tel;
    }
    public String getMail(){return mail;}
    public String getMember(){return member;}
    public ArrayList<Activities> getActivities(){return activities;}
    public String getIntro(){return intro;}
    public String getInformation(){return information;}
    public int getArraySize(){
        return this.activities.size();
    }
 }
