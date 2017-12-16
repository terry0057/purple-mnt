package purple.mnt.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.net.HttpURLConnection;
import java.net.URL;


public class HelloJob  implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 执行响应的任务.
        String urlstr="";
        try {
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(30000);




        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("你好！"+new Date());

    }
}
