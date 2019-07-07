package com.huangmj.controllers;

import com.huangmj.entity.Book;
import com.huangmj.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
//    @ResponseBody
    public String list(){
        List<Book> list = bookService.getList();
//        return list.get(0).toString();
//        return "his";
        return "WEB-INF/home.html";

    }

}
