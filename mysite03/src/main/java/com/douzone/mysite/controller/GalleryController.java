package com.douzone.mysite.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.service.FileUploadService;
import com.douzone.mysite.service.GalleryService;
import com.douzone.mysite.vo.GalleryVo;


@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	
	@Autowired
	private GalleryService galleryService;
	
	
	@Autowired
	FileUploadService fileuploadService;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("list",galleryService.() );
		return "gallery/index";
	}
	
	
	@Auth(role="ADMIN")
	@RequestMapping(value ="gallery/upload",method=RequestMethod.POST)
	public String upload(@RequestParam(value="file")MultipartFile file,GalleryVo vo){  {
		String url =fileuploadService.restore(file);
		vo.setUrl(url);
		galleryService.upload(vo);
		return "redirect:/gallery";
		
	}
	
//	@RequestMapping("/delete/{no}")
//	public String delete(@PathVariable(value="no") String no) {
//		galleryService.delete(Long.parseLong(no));
//		return "redirect:/gallery";
//	}
	
	
}
	
}