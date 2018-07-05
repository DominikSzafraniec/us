package dao.impl;

import dao.DeclarationDaoInterface;
import model.Declaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static config.DatabaseConfiguration.getSessionFactory;

public class DeclarationDao implements DeclarationDaoInterface<Declaration, Long>{
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void persist(Declaration entity) {
        getCurrentSession().save(entity);
    }


    public void update(Declaration entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Declaration findById(Long id) {
        Declaration declaration = getCurrentSession().get(Declaration.class, id);
        return declaration;
    }

    @Override
    public List<Declaration> findAllUserDeclaration(Long pesel) {
        List<Declaration> declarations = (List<Declaration>) getCurrentSession().createQuery("select d from Declaration d where d.person.pesel=:pesel ").setParameter("pesel", pesel).list();
        return declarations;
    }

    public void delete(Declaration entity) {
        getCurrentSession().delete(entity);
    }

    public List<Declaration> findAll() {
        @SuppressWarnings("unchecked")
        List<Declaration> declarations = (List<Declaration>) getCurrentSession().createQuery("from Declaration ").list();
        return declarations;
    }
}
