package real.socket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import real.socket.models.Logs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class LogsDAOImpl implements LogsDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addLog(Logs log) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(log);
        transaction.commit();;
        session.close();
    }

    @Override
    public List<Logs> getAllLogs() {
        Session session=sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Logs> query=builder.createQuery(Logs.class);
        query.from(Logs.class);
        List<Logs> allLogs=session.createQuery(query).list();
        session.close();
        return allLogs;
    }


}
