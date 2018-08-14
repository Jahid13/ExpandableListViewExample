package com.bashar.expandablelistviewexample;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class ExpandableListDataAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListGroupTitle;
    private HashMap<String, List<String>> expandableListDetailData;

    public ExpandableListDataAdapter(Context context, List<String> expandableListGroupTitle,
                                     HashMap<String, List<String>> expandableListDetailData) {
        this.context = context;
        this.expandableListGroupTitle = expandableListGroupTitle;
        this.expandableListDetailData = expandableListDetailData;
    }
    @Override
    public int getGroupCount() {
        return this.expandableListGroupTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.expandableListDetailData.get(this.expandableListGroupTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.expandableListGroupTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return this.expandableListDetailData.get(this.expandableListGroupTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupText = (String) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group_row, null);

        }
        TextView groupTextView = (TextView) convertView.findViewById(R.id.group_text);
        Switch groupSwitch = (Switch) convertView.findViewById(R.id.group_switch);

        groupTextView.setText(groupText);
        groupTextView.setTypeface(null, Typeface.BOLD);
        groupSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "switch clicked", Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_child_row, null);
        }

        TextView childTextView = (TextView) convertView.findViewById(R.id.child_text);
        CheckBox childCheckBox = (CheckBox)convertView.findViewById(R.id.child_checkbox);

        childTextView.setText(childText);
        childCheckBox.setChecked(true);

        childCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "checkbox clicked", Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
