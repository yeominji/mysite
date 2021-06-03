package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.GuestbookRepository;
import com.douzone.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	GuestbookRepository guestbookRepository;
	
	public void add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}
}
