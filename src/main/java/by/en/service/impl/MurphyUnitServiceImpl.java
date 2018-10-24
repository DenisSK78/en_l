package by.en.service.impl;

import by.en.dao.MurphyUnitDAO;
import by.en.entity.MurphyUnit;
import by.en.service.MurphyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MurphyUnitServiceImpl implements MurphyUnitService {

    private final MurphyUnitDAO murphyUnitDAO;

    @Autowired
    public MurphyUnitServiceImpl(MurphyUnitDAO murphyUnitDAO) {
        this.murphyUnitDAO = murphyUnitDAO;
    }

    @Override
    @Transactional
    public List<MurphyUnit> findAll() {
        return murphyUnitDAO.findAll();
    }

    @Override
    @Transactional
    public void saveUnit(MurphyUnit unit) {
        murphyUnitDAO.save(unit);
    }

    @Override
    @Transactional
    public MurphyUnit getUnitByNumber(Integer number) {
        return murphyUnitDAO.getUnitByNumber(number);
    }
}
