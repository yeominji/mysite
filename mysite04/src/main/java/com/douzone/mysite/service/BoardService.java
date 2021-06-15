package com.douzone.mysite.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

@Service 


public class BoardService {
	@Autowired
	BoardRepository boardRepository;
	@Transactional
		public BoardVo findByNo(long no) {
		return  boardRepository.findByNo(no);
	
	}

	public int update(BoardVo vo) {
		return boardRepository .updateBoard(vo);
		
	}

	public int write(BoardVo vo) {
	  return boardRepository.insert(vo);
	
		
	}

	public int findgroupNo() {
		return boardRepository.findgroupNo();		
	}

	public List<BoardVo> findAll() {
		return boardRepository.findAll();
		
	}
	public int updatehit (BoardVo vo) {
		return boardRepository.updatehit(vo);
	}

	public int delete(long no) {
     return  boardRepository.delete(no);		
	}

	public void insertreply(String no, BoardVo vo, UserVo authUser) {
		BoardVo orgin =boardRepository.findByNo(Long.parseLong(no));
		
		BoardVo newboard = new BoardVo();
		newboard.setContents(vo.getContents());
		newboard.setTitle(vo.getTitle());
		newboard.setHit(0);
		newboard.setGroupNo(orgin.getGroupNo());
		newboard.setOrderNo(orgin.getOrderNo()+1);
		newboard.setDepth(orgin.getDepth()+1);
		newboard.setUserNo(authUser.getNo());
		newboard.setUserName(authUser.getName());
		System.out.println(newboard.toString());
		boardRepository.updateNo(newboard);
		boardRepository.insert(newboard);
		
	}
 
}
