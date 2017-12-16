package purple.mnt;

import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.quartz.impl.StdSchedulerFactory;

import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.service.ActionJob;



@ServletComponentScan
@SpringBootApplication
@MapperScan("purple.mnt.mapper")
public class MntApplication {


	/*public static void main(String[] args) {
		SpringApplication.run(MntApplication.class, args);
	}*/

    public static void main(String[] args) throws SchedulerException,InterruptedException  {



		 //在 Quartz 中， scheduler 由 scheduler 工厂创建：DirectSchedulerFactory 或者 StdSchedulerFactory。第二种工厂 StdSchedulerFactory 使用较多，
		 //因为 DirectSchedulerFactory 使用起来不够方便，需要作许多详细的手工编码设置。

		// 获取Scheduler实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		System.out.println("scheduler.start");

		//具体任务.
		JobDetail jobDetail = JobBuilder.newJob(ActionJob.class).withIdentity("job1","group1").build();

		//触发时间点. (每5秒执行1次.)
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();


		//CronScheduleBuilder cronScheduleBuilder= CronScheduleBuilder.cronSchedule("");

		//Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(cronScheduleBuilder).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
				.startNow()
				//.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)) //每几秒钟执行一次
				//.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(14,40)) //每天某个时间点执行
				.build();

		// 交由Scheduler安排触发
		scheduler.scheduleJob(jobDetail,trigger);

		//睡眠20秒.
		//TimeUnit.SECONDS.sleep(20);
		//scheduler.shutdown();//关闭定时任务调度器.
		//System.out.println("scheduler.shutdown");
	}
}
