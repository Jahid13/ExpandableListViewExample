package com.bashar.expandablelistviewexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {

    public static HashMap<String, List<String>> getExpandableListData() {
        HashMap<String, List<String>> expandableListDetailData = new HashMap<String, List<String>>();

        List<String> sendMessage = new ArrayList<String>();

        sendMessage.add("Child 1");
        sendMessage.add("Child 2");
        sendMessage.add("Child 3");

        List<String> managePower = new ArrayList<String>();
        managePower.add("Child 1");
        managePower.add("Child 2");
        managePower.add("Child 3");

        expandableListDetailData.put("Group 2", managePower);
        expandableListDetailData.put("Group 1", sendMessage);


        return expandableListDetailData;

    }
}
