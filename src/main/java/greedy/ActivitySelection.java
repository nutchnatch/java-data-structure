package greedy;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {
        ActivitySelection activitySelection = new ActivitySelection();
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));
        activitySelection.activitySelection(activityList);
    }

    void activitySelection(List<Activity> activityList) {
        Comparator<Activity> finishComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };

        Collections.sort(activityList, finishComparator);
        Activity previousActivity = activityList.get(0);
        System.out.println("Recommended Schedule: \n" + activityList.get(0));
        for(int i = 1; i < activityList.size(); i ++) {
            final Activity activity = activityList.get(i);
            if(activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }
}
