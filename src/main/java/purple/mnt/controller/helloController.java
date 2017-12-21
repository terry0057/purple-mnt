package purple.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import purple.mnt.model.MssAppMonitor;
import purple.mnt.model.MssHealth;
import purple.mnt.service.testService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/hello")
public class helloController  {

    @Autowired
    private testService testService;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String authorize()  throws InterruptedException {

        List<MssAppMonitor> list= testService.action2();
        //TimeUnit.SECONDS.sleep(10);
        //Thread.sleep(10);
        return   list.get(0).getApp_name();
        //String serverName = request.getServerName();
    }

}
