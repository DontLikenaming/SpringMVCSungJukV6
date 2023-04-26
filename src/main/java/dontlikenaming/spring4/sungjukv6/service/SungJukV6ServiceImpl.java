package dontlikenaming.spring4.sungjukv6.service;

import dontlikenaming.spring4.sungjukv6.dao.SungJukV4DAO;
import dontlikenaming.spring4.sungjukv6.model.SungJukVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sjsrv")
public class SungJukV6ServiceImpl implements SungJukV6Service {
    private List<SungJukVO> sjs = null;
    private SungJukV4DAO sjdao = null;

    @Autowired
    public SungJukV6ServiceImpl(SungJukV4DAO sjdao) {
        this.sjdao = sjdao;
    }

    //성적 데이터 저장
    public boolean newSungJuk(SungJukVO sj) {
        return false;
    }

    // 성적 데이터 처리
    public void computeSungJuk(SungJukVO sj) {

    }

    // 성적 리스트 받아옴
    public List<SungJukVO> readSungJuk() {

        return sjdao.selectSungJuk();
    }

    public SungJukVO readOneSungJuk(int sjno) {
        return null;
    }

    public boolean modifySungJuk(SungJukVO sj) {
        return false;
    }

    public boolean removeSungJuk(int sjno) {
        return false;
    }
}
