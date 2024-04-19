package service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAOImpl;
import repository.BoardDao;

public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDao bdao;
	

	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("register >> BoardService 들어왔습니다.");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list >> BoardService 들어왔습니다.");
		return bdao.getlist();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail >> BoardService 들어왔습니다.");
		return bdao.getdetail(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update >> BoardService 들어왔습니다.");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info("remove >> BoardService 들어왔습니다.");
		return bdao.remove(bno);
	}



	@Override
	public List<BoardVO> searchMy(String writer) {
		log.info("searchMy >> BoardService 들어왔습니다.");
		return bdao.searchMy(writer);
	}
}
