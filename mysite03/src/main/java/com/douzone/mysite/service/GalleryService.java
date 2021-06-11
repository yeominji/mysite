package com.douzone.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.GalleryRepository;
import com.douzone.mysite.vo.GalleryVo;
@Service
public class GalleryService {
@Autowired
GalleryRepository galleryRepository;

	

public Object upload(GalleryVo vo) {
		return galleryRepository.updateload(vo);
		
	}


//public void delete(long parseLong) {
//	
//	return galleryRepository.delete(no);
	
}

