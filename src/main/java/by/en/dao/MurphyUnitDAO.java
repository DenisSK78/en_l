package by.en.dao;

import by.en.entity.MurphyUnit;

public interface MurphyUnitDAO extends BaseDao<MurphyUnit> {
    MurphyUnit getUnitByNumber(Integer e);
}
