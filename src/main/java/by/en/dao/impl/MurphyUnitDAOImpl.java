package by.en.dao.impl;

import by.en.dao.MurphyUnitDAO;
import by.en.entity.MurphyUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MurphyUnitDAOImpl extends BaseDAOImpl<MurphyUnit> implements MurphyUnitDAO {

    @Override
    public MurphyUnit getUnitByNumber(Integer number) {
        return getSession().createQuery("select u from MurphyUnit u where u.number=:number", MurphyUnit.class)
                .setParameter("number", number).uniqueResult();
    }
}
