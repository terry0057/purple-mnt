package purple.mnt.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.model.MssHealth;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class ActionJob implements Job {

    @Autowired
    MssHealthMapper mssHealthMapper;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 执行响应的任务.
        String urlstr="http://eas.nbeport.com/ctnf/rest/sta/get_pass_data";
        String status="";
        String msg="";




        try {
            List<MssHealth> mssHealthList = mssHealthMapper.getAll222();
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(30000);

            //for (MssHealth mssHealth:mssHealthList) {
            //}

            if(200 == urlConnection.getResponseCode()){
                //得到输入流
                InputStream is =urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while(-1 != (len = is.read(buffer))){
                    baos.write(buffer,0,len);
                    baos.flush();
                }
                //return baos.toString("utf-8");
                 msg=baos.toString("utf-8");
                status = msg.startsWith("error") ? "0" : "1";

                //System.out.println(baos.toString("utf-8"));
            }


        } catch (IOException e) {
            //e.printStackTrace();
            status = "0";
            msg = e.getMessage();
        }
        System.out.println("status :" + status +";msg :"+msg);


       // System.out.println("你好！"+new Date());

    }
}
