package l3.dao;

import l3.dataSet.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Cole S' Offe on 03.04.2017.
 */
public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public UsersDataSet getUserPassword(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return (UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    public long insertUser(String name, String pass) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name, pass));
    }
}
