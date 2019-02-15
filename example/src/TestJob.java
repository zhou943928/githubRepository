import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class TestJob {

    public void doRemind() throws SchedulerException,InterruptedException{

        //创建一个任务
        JobDetail job = new JobDetail("remindJob","group1",RemindJob.class);
        JobDataMap dataMap = job.getJobDataMap();
        dataMap.put("user", "张三");
        //创建一个触发器
        SimpleTrigger simTrig = new SimpleTrigger("trigRemindJob",SimpleTrigger.REPEAT_INDEFINITELY,3000);
        simTrig.setStartTime(new Date(System.currentTimeMillis()+1000));
        //使用TriggerUtil的方式
		/*Trigger simTrig = TriggerUtils.makeSecondlyTrigger(3);
		simTrig.setName("remindJob");*/
        //创建调度者工厂
        SchedulerFactory sfc = new StdSchedulerFactory();
        //创建一个调度者
        Scheduler sched = sfc.getScheduler();
        //注册并进行调度
        sched.scheduleJob(job, simTrig);
        //启动调度
        sched.start();
        //sleep10s
        Thread.sleep(10000);
        //关闭调度
        sched.shutdown();
    }

    public static void main(String[] args){
        try{
            TestJob testJob = new TestJob();
            testJob.doRemind();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
