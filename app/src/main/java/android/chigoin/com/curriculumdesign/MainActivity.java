package android.chigoin.com.curriculumdesign;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar=(Toolbar) findViewById(R.id.toolbal);
        setSupportActionBar(toolBar);
        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.floatingbutton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"you clicked the FloatingBUtton",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,QueryActivity.class);
                startActivity(intent);
            }
        });
       RollPagerView viewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        viewPager.setPlayDelay(1000);
        //设置透明度
        viewPager.setAnimationDurtion(600);
        //设置适配器
        viewPager.setAdapter(new TestNormalAdapter());
         //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        viewPager.setHintView(new ColorPointHintView(this, Color.BLUE,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
        viewPager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
               Intent cardIntent=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(cardIntent);
            }
        });
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
