package com.douzone.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.GalleryVo;

@Repository
public class GalleryRepository {
 @Autowired
 private SqlSession sqlSession;
    
   public int insert (GalleryVo vo) {
	return sqlSession.insert("gallery.insert",vo);
   }
	

//     public Object delete (Long no) {
//	return sqlSession.delect("gallery.Delete",no);
//	}
//	


     public Object updateload(GalleryVo vo) {
	        return sqlSession.update("gallery.upload",vo);
}
	
	
	
	
	
	
}
