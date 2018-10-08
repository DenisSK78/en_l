package by.en.service;

import by.en.entity.MurphyUnit;

import java.util.List;

public interface MurphyUnitService {

    List<MurphyUnit> findAll();

    void saveUnit(MurphyUnit unit);

    MurphyUnit getUnitByNumber(Integer number);
}
