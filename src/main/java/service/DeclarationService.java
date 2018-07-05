package service;

import dao.impl.DeclarationDao;
import model.Declaration;

import java.util.List;

public class DeclarationService {
    private static DeclarationDao declarationDao;

    public DeclarationService() {declarationDao=new DeclarationDao();}

    public void persist(Declaration entity)
    {
        declarationDao.openCurrentSessionWithTransaction();
        declarationDao.persist(entity);
        declarationDao.closeCurrentSessionWithTransaction();
    }
    public void update(Declaration entity) {
        declarationDao.openCurrentSessionWithTransaction();
        declarationDao.update(entity);
        declarationDao.closeCurrentSessionWithTransaction();

    }

    public Declaration findById(Long id) {
        declarationDao.openCurrentSession();
        Declaration declaration = declarationDao.findById(id);
        declarationDao.closeCurrentSession();
        return declaration;
    }

    public void delete(Long id) {
        declarationDao.openCurrentSessionWithTransaction();
        Declaration declaration = declarationDao.findById(id);
        declarationDao.delete(declaration);
        declarationDao.closeCurrentSessionWithTransaction();
    }
    public List<Declaration> findAllUserDeclaration(Long pesel) {
        declarationDao.openCurrentSession();
        List<Declaration> declarations = declarationDao.findAllUserDeclaration(pesel);
        declarationDao.closeCurrentSession();
        return declarations;
    }

    public List<Declaration> findAll() {
        declarationDao.openCurrentSession();
        List<Declaration> declarations = declarationDao.findAll();
        declarationDao.closeCurrentSession();
        return declarations;
    }
}
