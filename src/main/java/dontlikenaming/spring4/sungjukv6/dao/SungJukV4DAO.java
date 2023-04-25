package dontlikenaming.spring4.sungjukv6.dao;

import dontlikenaming.spring4.sungjukv6.model.SungJukVO;

import java.util.List;

public interface SungJukV4DAO {
    int insertSungJuk(SungJukVO sjs);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(int sjnum);
    int updateSungJuk(SungJukVO sjs);
    int deleteSungJuk(int sjnum);
}
