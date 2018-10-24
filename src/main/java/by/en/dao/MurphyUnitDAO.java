package by.en.dao;

import by.en.entity.MurphyUnit;

public interface MurphyUnitDAO extends BaseDAO<MurphyUnit> {
    MurphyUnit getUnitByNumber(Integer e);
}
