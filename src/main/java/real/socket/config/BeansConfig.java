package real.socket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import real.socket.dao.LogsDAO;
import real.socket.dao.LogsDAOImpl;

@Configuration
@Scope("singleton")
public class BeansConfig {

    @Bean
    public LogsDAO logsDAO(){
        return new LogsDAOImpl();
    }


}
