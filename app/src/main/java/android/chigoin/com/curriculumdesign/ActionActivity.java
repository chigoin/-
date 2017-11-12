package android.chigoin.com.curriculumdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;


public class ActionActivity extends AppCompatActivity {

    private ArrayList<String> activityList=new ArrayList<>();
    private ActivitiesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        Toolbar toolbar=(Toolbar) findViewById(R.id.atoolbar);
        setSupportActionBar(toolbar);
        final Intent intent=getIntent();
        activityList=intent.getStringArrayListExtra("activities");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_2);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ActivitiesAdapter(activityList);
        recyclerView.setAdapter(adapter);
    }
}
