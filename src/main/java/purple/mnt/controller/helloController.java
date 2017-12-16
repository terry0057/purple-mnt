package purple.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import purple.mnt.model.MssHealth;
import purple.mnt.service.testService;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class helloController {

    /*@Autowired
    private testService testService;*/

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String authorize()   {

        //List<MssHealth> list= testService.action();
        return  "123";
        //String serverName = request.getServerName();
    }

}
