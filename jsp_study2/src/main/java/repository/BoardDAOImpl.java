package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDao {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	//DB 설정 mybatis lib 사용하여 DB를 구성
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(BoardVO bvo) {
		//insert, update, delete는 DB가 변경되는 구문 반드시 commit 필요
		log.info("insert >> DAO 들어왔습니다.");
		int isOk = sql.insert("BoardMapper.insert",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public List<BoardVO> getlist() {
		log.info("list >> DAO 들어왔습니다.");
		return sql.selectList("BoardMapper.list");
	}
	@Override
	public BoardVO getdetail(int bno) {
		log.info("detail >> DAO 들어왔습니다.");
		return sql.selectOne("BoardMapper.detail", bno);
	}
	@Override
	public int update(BoardVO bvo) {
		log.info("update >> DAO 들어왔습니다.");
		int isOk = sql.update("BoardMapper.update", bvo);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}
	@Override
	public int remove(int bno) {
		log.info("remove >> DAO 들어왔습니다.");
		int isOk = sql.delete("BoardMapper.remove", bno);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	public List<BoardVO> searchMy(String writer) {
		log.info("searchMy >> DAO 들어왔습니다.");
		return sql.selectList("BoardMapper.searchMy", writer);
	}

}
