package com.example.chdating;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.example.chdating.ui.login.LoginActivity;

import java.util.ArrayList;




public class TabLayoutActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawer;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentStatePagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"最新", "热门", "我的", "广寒宫", "神箭营", "俱乐部","艺苑","旅游","夜生活","游戏","视频"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tablayout);
        init();
    }

    private void init() {

        mToolBar = findViewById(R.id.toolbar1);
        mDrawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav);

        mToolBar.setLogo(R.mipmap.ic_launcher);
        mToolBar.setTitle("安大略得空约会");
        mToolBar.setSubtitle("---勇敢地迈出第一步，从此就告别寂寞！");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_format_list_bulleted_black_24dp);

        getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.toolbar_search:
                        msg += "众里寻他千百度，蓦然回首，他/她在灯火阑珊处。";
                        break;
                    case R.id.toolbar_notifications:
                        msg += "你的心上人就在前方不远处等着你。";
                        break;
                    case R.id.toolbar_settings:
                       // msg += "有什么好的活动，和大家一起分享吧。";
                        Intent intent;
                        intent=new Intent(TabLayoutActivity.this, DKsettingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(TabLayoutActivity.this,"我的好友正在做什么呢？", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(TabLayoutActivity.this,"多个朋友，多条路", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(TabLayoutActivity.this,"希望这是一次愉快的相会", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(TabLayoutActivity.this,"微信、Facebook", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(TabLayoutActivity.this,"快乐每一天", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(TabLayoutActivity.this,"参加聚会，如果要喝酒，就打车前往吧", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                if (!msg.equals("")) {
                    Toast.makeText(TabLayoutActivity.this, msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });


        //View headerview=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.menu_infoinput:
                        //msg += "我的个人情况，爱好，心愿......";
                        //navigationView.setVisibility(View.INVISIBLE);
                        Intent intent;
                        intent=new Intent(TabLayoutActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menu_findgirl:
                        msg += "好妹妹，你在哪里？";
                        navigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.menu_findboy:
                        msg += "大哥哥，什么时候带我出去旅游？";
                        navigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.menu_publishactivity:
                        msg += "你有什么好的活动可以和大家分享？";
                        navigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.menu_word:
                        msg += "满腹的话儿想对外人倾述......";
                        navigationView.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.menu_exit:
                        //msg += "暂时离开此温柔乡。";
                        //navigationView.setVisibility(View.INVISIBLE);
                        AlertDialog.Builder builder=new AlertDialog.Builder(TabLayoutActivity.this);
                        builder.setTitle("亲爱的朋友：");
                        builder.setMessage("你是不是已经找到了一个兴趣契合，相互欣赏的朋友？");
                        builder.setPositiveButton("有空再回来", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                navigationView.setVisibility(View.INVISIBLE);
                                Toast.makeText(TabLayoutActivity.this, "虽然依依不舍，但是只能暂时离开了", Toast.LENGTH_LONG).show();
                            }
                        });
                        builder.setNegativeButton("继续寻找朋友", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TabLayoutActivity.this, "今天花点时间，希望朋友就在不远处等着我", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();
                        break;

                    default:
                        break;

                }
                if (!msg.equals("")) {
                    Toast.makeText(TabLayoutActivity.this, msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });


        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        for (int i = 0; i < titles.length; i++) {
            fragments.add(new Fragment());
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager, false);
        pagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(pagerAdapter);

        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        SubMenu social = menu.addSubMenu("我的社交圈");
        SubMenu tool = menu.addSubMenu("我的社交工具");
        social.add(1, 1, 1, "好友");
        social.add(1, 2, 2, "普通朋友");
        social.add(1, 3, 3, "约会安排");
        social.setHeaderTitle("社交圈");
        //已经失效 social.setIcon(R.drawable.ic_sms_black_24dp);
        tool.add(2, 4, 1, "社交账户");
        tool.add(2, 5, 2, "吃喝玩乐");
        tool.add(2, 6, 3, "打车软件");
        tool.setHeaderTitle("社交工具");
        //已经失效 tool.setIcon(R.drawable.ic_portrait_black_24dp);

        return true;
    }

    //显示toolbar左侧的NavigationView按钮的内容——侧滑菜单，只有这种方法才有效。
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        navigationView.setVisibility(View.VISIBLE);
        return super.onOptionsItemSelected(menuItem);
    }
}



