package com.marvhong.baseframe.component;

import android.app.Activity;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.component
 * @Date 2018/8/30 15:21
 * @description 一键退出app
 */
public class ActivityCollector {

    private static ActivityCollector activityCollector;

    public synchronized static ActivityCollector getInstance() {
        if (activityCollector == null) {
            activityCollector = new ActivityCollector();
        }
        return activityCollector;
    }

    private Set<Activity> allActivities;

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
