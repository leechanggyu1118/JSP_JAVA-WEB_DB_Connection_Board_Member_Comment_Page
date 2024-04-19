package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDao {

	int insert(BoardVO bvo);

	List<BoardVO> getlist();

	BoardVO getdetail(int bno);

	int update(BoardVO bvo);

	int remove(int bno);


	List<BoardVO> searchMy(String writer);

}
