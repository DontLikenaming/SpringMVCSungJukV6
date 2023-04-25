package dontlikenaming.spring4.sungjukv6.service;

import dontlikenaming.spring4.sungjukv6.model.SungJukVO;

import java.util.List;

public interface SungJukV6Service {
    void newSungJuk();
    void computeSungJuk(SungJukVO sj);
    List<SungJukVO> readSungJuk();
    void readOneSungJuk();
    void modifySungJuk();
    void removeSungJuk();
}

