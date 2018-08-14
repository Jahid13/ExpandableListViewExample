package com.bashar.expandablelistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListDataAdapter expandableListDataAdapter;
    List<String> expandableListGroupTitle;
    HashMap<String, List<String>> expandableListDetailData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        expandableListDetailData = ExpandableListData.getExpandableListData();
        expandableListGroupTitle = new ArrayList<String>(expandableListDetailData.keySet());
        expandableListDataAdapter = new ExpandableListDataAdapter(this, expandableListGroupTitle, expandableListDetailData);
        expandableListView.setAdapter(expandableListDataAdapter);



        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableListGroupTitle.get(groupPosition) + "List Expanded", Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), expandableListGroupTitle.get(groupPosition) + "List Collapsed", Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), expandableListDetailData.get(expandableListGroupTitle.get(groupPosition)).get(childPosition), Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}
