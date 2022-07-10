package real.socket.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import real.socket.dao.LogsDAO;
import real.socket.models.Logs;
import real.socket.service.GreeterService;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    LogsDAO logsDAO;


    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreeterService greeting(Logs message) throws Exception {

        if (message.getCommand().equals("addLog")){

            Logs log=new Logs(message.getContent(),message.getCommand());
            //DAO addLog

            logsDAO.addLog(log);

            return new GreeterService("Content: " + message.getContent()+" Command: "+message.getCommand() + "!");
        }else{
            //DAO logs

            List<Logs> allLogs=logsDAO.getAllLogs();

            return new GreeterService(" Command "+message.getCommand() + ", Content list: ", allLogs);
        }
    }

    @RequestMapping(value = "/simMessage")
    public String greeting() throws Exception {
        template.convertAndSend("/topic/greetings",
                new GreeterService("Hello, Other!"));
        return "sample";
    }
}
