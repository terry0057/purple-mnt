package purple.mnt.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import purple.mnt.mapper.MssAppMonitorMapper;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.model.MssAppMonitor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class ActionJob {

    @Autowired
    private MssHealthMapper mssHealthMapper;

    @Autowired
    private MssAppMonitorMapper mssAppMonitorMapper;

    @Scheduled(fixedRate = 100000)
    public void execute() {
        // 执行响应的任务.
        String status = "";
        String msg = "";
        //List<MssHealth> mssHealthList = mssHealthMapper.getAll();

        List<MssAppMonitor> mssAppMonitorList = mssAppMonitorMapper.getAll();
        //System.out.println("status :" + mssAppMonitorList.get(0).getApp_name() + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        for (MssAppMonitor mssAppMonitor : mssAppMonitorList) {

            LocalDateTime LastModifydate = mssAppMonitor.getModify_time();
            Duration duration = java.time.Duration.between(LastModifydate, LocalDateTime.now());
            //long difference = (nowData.getTime() - LastModifyda())/(60*1000);
            if (mssAppMonitor.getFixed_rate() != null) {
                long difference = duration.toMinutes();
                if (difference < mssAppMonitor.getFixed_rate()) {
                    continue;
                }

            }


            try {
                //访问对于url
                URL url = new URL(mssAppMonitor.getMnt_nul());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(30000);

                if (200 == urlConnection.getResponseCode()) {
                    //得到输入流
                    InputStream is = urlConnection.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while (-1 != (len = is.read(buffer))) {
                        baos.write(buffer, 0, len);
                        baos.flush();
                    }
                    status = baos.toString("utf-8").startsWith("error") ? "0" : "1";
                } else {
                    status = "0";
                    msg = urlConnection.getResponseMessage();
                }
            } catch (IOException e) {
                status = "0";
                msg = e.getMessage();
            } finally {
                mssAppMonitor.setStatus(status);
                mssAppMonitor.setModify_time(LocalDateTime.now());
                mssAppMonitor.setRemark(msg);
            }
            mssAppMonitorMapper.UpdateModfiyTimeById(mssAppMonitor);

            //System.out.println("status :" + status +";msg :"+msg);
        }

        // System.out.println("你好！"+new Date());

    }
}
