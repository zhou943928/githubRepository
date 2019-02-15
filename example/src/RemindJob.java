import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class RemindJob implements Job{
    public RemindJob(){}
    private RemindService remindService;
    @Override
    public void execute(JobExecutionContext jobContext) throws JobExecutionException {
        //获取调度上下文的信息
        System.out.print("TriggerName: "+ jobContext.getTrigger().getName()
                + "&TriggerTime:"+new Date()
                + "&JobName:"+jobContext.getJobDetail().getName()+"\n");

        //获取用户信息
        JobDataMap dataMap = jobContext.getJobDetail().getJobDataMap();
        String userName = (String)dataMap.get("user");

        remindService = new RemindService();
        remindService.ouputPlan(userName);
    }
}
