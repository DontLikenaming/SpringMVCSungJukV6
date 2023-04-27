import dontlikenaming.spring4.sungjukv6.model.SungJukVO;
import dontlikenaming.spring4.sungjukv6.service.SungJukV6Service;
import dontlikenaming.spring4.sungjukv6.service.SungJukV6ServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SungJukV6ServiceTest {
    // SungJukV6Service sjsrv = new SungJukV6ServiceImpl(null);

    SungJukV6Service sjsrv;

    @Before
    public void setup() {
        sjsrv = new SungJukV6ServiceImpl(null);
    }

    @Test
    public void Test1() {
        SungJukVO sj = new SungJukVO("test1", 100, 100, 100);
        sjsrv.computeSungJuk(sj);

        assertEquals(sj.getTot(),300);
        // 실수가 포함될 경우 허용 오차범위를 지정해야 함
        assertEquals(sj.getAvg(),100, 0.0);
        assertEquals(sj.getGrd(),'수');
    }
}
