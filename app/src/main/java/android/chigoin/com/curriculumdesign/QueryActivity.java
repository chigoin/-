package android.chigoin.com.curriculumdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Toolbar toolBar=(Toolbar) findViewById(R.id.qtoolbar);
        setSupportActionBar(toolBar);
        Button button1=(Button) findViewById(R.id.q1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                List<Club> clubs= DataSupport.findAll(Club.class);
                Toast.makeText(QueryActivity.this,clubs.get(0).getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
