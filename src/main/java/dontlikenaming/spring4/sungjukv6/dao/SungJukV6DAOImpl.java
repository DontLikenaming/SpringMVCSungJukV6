package dontlikenaming.spring4.sungjukv6.dao;

import com.sun.org.apache.bcel.internal.generic.ObjectType;
import dontlikenaming.spring4.sungjukv6.model.SungJukVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("sjdao")
public class SungJukV6DAOImpl implements SungJukV4DAO{
    private JdbcTemplate jdbcTemplate;
    
    // jdbc.properties에 정의한 SQL 가져오기
    @Value("#{jdbc['insertSQL']}") private String insertSQL;
    @Value("#{jdbc['selectSQL']}") private String selectSQL;
    @Value("#{jdbc['selectOneSQL']}") private String selectOneSQL;
    @Value("#{jdbc['updateSQL']}") private String updateSQL;
    @Value("#{jdbc['deleteSQL']}") private String deleteSQL;

    @Autowired
    public SungJukV6DAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSungJuk(SungJukVO sjs) {
        int cnt = -1;

        try {
            // 매개변수 정의
            Object[] params = new Object[]{
                    sjs.getName(), sjs.getKor(),
                    sjs.getEng(), sjs.getMat(),
                    sjs.getTot(), sjs.getAvg(),
                    sjs.getGrd()+""
            };

            cnt = jdbcTemplate.update(insertSQL, params);
        } catch (Exception ex){
            System.out.println("insertSungJuk 오류!!");
            ex.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<SungJukVO> selectSungJuk() {
        // 콜백 메서드 선언
        // 즉, SQL을 실행하고, 결과 집합이 존재하는 경우
        // 스프링 컨테이너에 의해 자동으로 호출하는 메서드
        RowMapper<SungJukVO> mapper = new SungJukMapper();

        return jdbcTemplate.query(selectSQL, mapper);
    }

    private class SungJukMapper implements RowMapper<SungJukVO> {
        @Override
        public SungJukVO mapRow(ResultSet rs, int num) throws SQLException {
            SungJukVO sj = new SungJukVO(
                    rs.getString(2), rs.getInt(3),
                    rs.getInt(4),rs.getInt(5));
            sj.setSjno(rs.getInt(1));


            return sj;
        }
    }

    @Override
    public SungJukVO selectOneSungJuk(int sjnum) {
        SungJukVO sj = null;

        return sj;
    }

    @Override
    public int updateSungJuk(SungJukVO sjs) {
        int cnt = -1;

        return cnt;
    }

    @Override
    public int deleteSungJuk(int sjnum) {
        int cnt = -1;

        return cnt;
    }


}
