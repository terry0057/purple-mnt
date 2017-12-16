package purple.mnt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.model.MssHealth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class Job2 {

    @Autowired
    private MssHealthMapper mssHealthMapper;

    //    每分钟启动
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){

        //List<MssHealth> mssHealthList = mssHealthMapper.getAll222();

        System.out.println("一分钟:"+"zzzz"+ "zzzzz" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
    //    项目运行后的每5秒一次
    //@Scheduled(fixedRate = 10000)
    public void timerToZZP(){

        List<MssHealth> mssHealthList = mssHealthMapper.getAll222();
        System.out.println("每10秒:" +mssHealthList.size() + ","+ new Random().nextLong() + new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

    //    项目启动后每50秒启动
    //@Scheduled(fixedDelay = 50000)
    public void timerToReportCount(){
        for (int i = 0; i < 10; i++){

            System.out.println("<================its" + i + "count===============>" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }
    //    第一次启动在项目启动后延迟50秒开始，之后每6秒执行一次
    //@Scheduled(initialDelay = 50000,fixedRate = 6000)
    public void timerToReport(){
        for (int i = 0; i < 10; i++){

            System.out.println("<================delay :" + i + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "count===============>");

        }
    }

}
