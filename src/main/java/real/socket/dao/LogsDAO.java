package real.socket.dao;

import real.socket.models.Logs;
import java.util.List;

public interface LogsDAO {

    void addLog(Logs log);

    List<Logs> getAllLogs();

}
