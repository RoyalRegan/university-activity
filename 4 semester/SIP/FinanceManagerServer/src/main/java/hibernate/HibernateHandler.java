package hibernate;

import hibernate.dao.UserEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

//TODO: hide mysql data from hibernate.cfg
public class HibernateHandler {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static <T> boolean addEntity(T entity) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static <T> T getEntity(Class<T> entityClass, int id) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            transaction.commit();
            return entity;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static UserEntity getUserByLogin(String login) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<UserEntity> criteria = criteriaBuilder.createQuery(UserEntity.class);
            Root<UserEntity> root = criteria.from(UserEntity.class);
            criteria.select(root).where(criteriaBuilder.equal(root.get("login"), login));
            List<UserEntity> userEntices = session.createQuery(criteria).getResultList();
            UserEntity userEntity = null;
            if (userEntices.size() > 0) {
                userEntity = userEntices.get(0);
            }
            transaction.commit();
            return userEntity;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static <T> void updateEntity(T entity) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> boolean deleteEntity(T entity) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static <T> List<T> getEntitys(Class<T> entityClass) {
        try (Session session = ourSessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = criteriaBuilder.createQuery(entityClass);
            Root<T> root = criteria.from(entityClass);
            criteria.select(root);
            List<T> entitys = session.createQuery(criteria).getResultList();
            transaction.commit();
            return entitys;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}