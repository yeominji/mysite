package com.douzone.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.mysite.service.GuestbookService;

@Controller("guestbookControllerApi")
@RequestMapping("/guestbook/api")
public class GuestbookController {
@Autowired
private GuestbookService guestbookService;
}
