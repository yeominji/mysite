package com.douzone.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.vo.GuestbookVo;
import com.dozone.mysite.repository.GuestbookRepository;

@Service
public class GuestbookService {

	@Autowired

	GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getMessageList (){
		return guestbookRepository.findAll();
	}
public void deletMessage(Long no ,String password) {
	
}

public void addMessage(GuestbookVo vo) {
 }
}
