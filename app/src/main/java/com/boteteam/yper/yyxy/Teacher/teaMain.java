package com.boteteam.yper.yyxy.Teacher;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.boteteam.yper.yyxy.Module.GradeClass;
import com.boteteam.yper.yyxy.Module.Teacher;
import com.boteteam.yper.yyxy.MyApplication;
import com.boteteam.yper.yyxy.R;
import com.boteteam.yper.yyxy.SchoolModule.Assignment;
import com.boteteam.yper.yyxy.Teacher.Adapter.TeaMainListAssignmentAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class teaMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  private   MyApplication myApplication=MyApplication.getInstance();
  private   Teacher teacher=myApplication.getTeacher();
    private List<Assignment> assignmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headview=navigationView.getHeaderView(0);
        TextView teatxt=(TextView)headview.findViewById(R.id.teaname);
        RecyclerView listView= (RecyclerView) findViewById(R.id.list_main_assignbz);

        // 做数据
        HashMap<GradeClass,String> gcesubject=myApplication.getGcsubjects();
        //作业数据
        List<Assignment> assignmentList=new ArrayList<>();

        Iterator iterator=gcesubject.entrySet().iterator();
        while (iterator.hasNext())
        {
            HashMap.Entry entry= (HashMap.Entry) iterator.next();
            GradeClass key= (GradeClass) entry.getKey();
            String val= (String) entry.getValue();
            Assignment assignment=new Assignment();
            assignment.setBzrid(teacher.get_id());
            assignment.setBzrname(teacher.getName());
            assignment.setSubject(val);
            assignment.setBj_id(key.get_id());
            assignment.setBjname(key.getName());
            assignment.setBztime(new Date());
            Calendar gc=Calendar.getInstance();
            gc.setTime(new Date());
            gc.add(Calendar.DATE,1);
            assignment.setJstime(gc.getTime());

            assignmentList.add(assignment);
        }


        TeaMainListAssignmentAdapter teaMainListAssignmentAdapter=new TeaMainListAssignmentAdapter(assignmentList,getApplicationContext());
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(teaMainListAssignmentAdapter);




        teatxt.setText(teacher.getName());
        loaddata();
    }

    private void loaddata()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
