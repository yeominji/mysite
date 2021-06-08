package com.douzone.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.BoardVo;

@Repository
public class BoardRepository {
	
	
	@Autowired
	private SqlSession sqlSession;
	

	public int  insert (BoardVo vo) {
		System.out.println(vo.toString());
		return sqlSession.insert("board.insert",vo);
	}

	public List<BoardVo> findAll() {
		return  sqlSession.selectList("board.findAll");
	}


	public BoardVo findByNo(Long no) {
		return  sqlSession.selectOne("board.findByNO",no);
	}
	
	public  int delete(Long no) {
		return sqlSession.delete("board.Delete",no);
	}
	
	public int updateBoard(BoardVo vo ) {
		return sqlSession.update("board.updateBoard",vo);

	}

	public int findgroupNo() {
		return sqlSession.selectOne("board.findgroupNo");
		
	}
	public int updatehit(BoardVo vo) {
		return sqlSession.update("board.updatehit", vo);
	}
	public int reply(BoardVo vo) {
		return sqlSession.update("board.reply", vo);
}

	public int updateNo(BoardVo vo) {
   return sqlSession.update("board.updateNo", vo);		
	}
}