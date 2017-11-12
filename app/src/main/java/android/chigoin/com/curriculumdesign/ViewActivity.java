package android.chigoin.com.curriculumdesign;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ViewActivity extends AppCompatActivity {


    /**={new Club("Drama Club",R.drawable.drama_img),new Club("Basketball Club",R.drawable.basket_img),
            new Club("Catroon Club",R.drawable.cartoon_img),new Club("Literature Club",R.drawable.literature_img),
            new Club("Free-combat Club",R.drawable.free_combat_img),new Club("Music Club",R.drawable.music_img),
            new Club("Psychology Club",R.drawable.psychology_img),new Club("Ping-pong CLub",R.drawable.ping_pong_img),
            new Club("Street-dance Club",R.drawable.street_img),new Club("Volunteer Club",R.drawable.volunteer_img)};*/
    //private DrawerLayout mDrawerLayout;
    private Club club0=new Club("Drama Club",R.drawable.drama_img);
    private Club club1=new Club("Basketball Club",R.drawable.basket_img);
    private Club club2=new Club("Catroon Club",R.drawable.cartoon_img);
    private Club club3=new Club("Literature Club",R.drawable.literature_img);
    private Club club4= new Club("Free-combat Club",R.drawable.free_combat_img);
    private Club club5=new Club("Music Club",R.drawable.music_img);
    private Club club6=new Club("Psychology Club",R.drawable.psychology_img);
    private Club club7=new Club("Ping-pong CLub",R.drawable.ping_pong_img);
    private Club club8=new Club("Street-dance Club",R.drawable.street_img);
    private Club club9=new Club("Volunteer Club",R.drawable.volunteer_img);
    private Club[] clubs={club0,club1,club2,club3,club4,club5,club6,club7,club8,club9};
    private List<Club>  clubList = new ArrayList<>();
    private ClubAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolBar=(Toolbar) findViewById(R.id.second_toolbal);
        setSupportActionBar(toolBar);
        startClubs();
        iniClubs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ClubAdapter(clubList);
        recyclerView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                refreshClubs();
            }
        });
       /**ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }*/
   }

    //@Override
   /** public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }*/

    private void refreshClubs(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                  Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iniClubs();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                        Toast.makeText(ViewActivity.this,"内容已刷新",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

    }

    private void startClubs(){
        Activities activity1=new Activities();
        activity1.setName("你的月亮我的心");
        activity1.setTime("2015.12.2");
        activity1.setSite("校舞台");
        activity1.setHolders("话剧社、文学社");
        activity1.save();
        Activities activity2=new Activities();
        activity2.setName("星座书上");
        activity2.setHolders("话剧社");
        activity2.setTime("2016.8.11");
        activity2.setSite("一教学楼102");
        activity2.save();
        club0.addActivity(activity1);
        club0.addActivity(activity2);
        for (int i=0;i<10;i++){
            clubs[i].save();
        }
    }

    private void iniClubs(){
        clubList.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(clubs.length);
            clubList.add(clubs[index]);
        }
    }
}
