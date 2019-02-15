import java.util.ArrayList;
import java.util.List;

public class RemindService {

    public void ouputPlan(String userName){
        List<Plan> plansForToday = getPlansForToday();
        System.out.print(userName + "的提醒信息：\n");
        for(Plan plan:plansForToday){
            System.out.print(plan +"\n");
        }
    }

    public List<Plan> getPlansForToday(){
        //模拟查询数据库
        List<Plan> list = new ArrayList<Plan>();
        list.add(new Plan("2003-8-9 9:00","研讨会 | 地点：会议室C01"));
        list.add(new Plan("2003-8-9 14:00","汇报 | 地点：总裁办公室"));
        return list;
    }
}
