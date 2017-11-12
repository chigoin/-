package android.chigoin.com.curriculumdesign;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class ClubActivity extends AppCompatActivity {
  //public static final String CLUB_NAME="fruit_name";
  //public static final String CLUB_IMAGE_ID="club_image_id";
    //public static  Activities ac1;
    //public static final String[] acNameList={"ac1","ac2","ac3","ac4","ac5"};
    public static ArrayList<String> tArrayList =new ArrayList<>();
    private static ArrayList<Activities> acList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        final Intent intent=getIntent();
        /**for (int i=0;i<5;i++){
            acList.add((Activities)getIntent().getParcelableExtra(acNameList[i]));
        }*/
        /**for (int i=0;i<5;i++){
            acList.add((Activities)getIntent().getParcelableExtra(acNameList[i]));
        }
        for (int i=0;i<acList.size();i++){
            tArrayList.add(acList.get(i).getName());
            tArrayList.add(acList.get(i).getTime());
            tArrayList.add(acList.get(i).getSite());
            tArrayList.add(acList.get(i).getHolders());
        }*/
        Activities activities=(Activities) getIntent().getParcelableExtra("activities1") ;
        tArrayList.add(activities.getName());
        tArrayList.add(activities.getHolders());
        tArrayList.add(activities.getTime());
        Activities activities1=(Activities) getIntent().getParcelableExtra("activities2") ;
        tArrayList.add(activities1.getName());
        tArrayList.add(activities1.getHolders());
        tArrayList.add(activities1.getTime());
        Club club=(Club) getIntent().getParcelableExtra("club_activities");
        String clubName=club.getName();
        int clubImageId=club.getImageId();
        //tArrayList=club.getActivities();
        //String clubName=intent.getStringExtra(CLUB_NAME);
        //int clubImageId=intent.getIntExtra(CLUB_IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.stoolbar);
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView clubImageView=(ImageView) findViewById(R.id.club_image_view);
        TextView clubContentText =(TextView) findViewById(R.id.club_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(clubName);
        Glide.with(this).load(clubImageId).into(clubImageView);
        String clubContent=generateClubContent(clubName);
        clubContentText.setText(clubContent);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1=new Intent(ClubActivity.this,ActionActivity.class);

                /*for (int i=0;i<2;i++){
                    tArrayList.add(acList.get(i).getName());
                    tArrayList.add(acList.get(i).getTime());
                    tArrayList.add(acList.get(i).getSite());
                    tArrayList.add(acList.get(i).getHolders());
                }*/
                intent1.putStringArrayListExtra("activities",tArrayList);
                startActivity(intent1);
            }
        });
    }
    private String generateClubContent(String clubName){
        StringBuilder clubContent=new StringBuilder();
        for(int i=0;i<500;i++){
            clubContent.append(clubName);
        }
        return clubContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
