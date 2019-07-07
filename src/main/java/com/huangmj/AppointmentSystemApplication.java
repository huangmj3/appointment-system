package com.huangmj;

import com.huangmj.dao.BookDao;
import com.huangmj.dto.AppointExecution;
import com.huangmj.entity.Book;
import com.huangmj.service.BookService;
import com.huangmj.service.impl.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@SpringBootApplication
public class AppointmentSystemApplication {

    public static void main(String[] args) {
        System.out.println("SpringBoot Start....");
        SpringApplication.run(AppointmentSystemApplication.class, args);
        System.out.println("End....");
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
//        System.out.println("init...");
        return "hi!spring boot!!!!!";
    }

    @RequestMapping(value = "/indexx")
    public String indexx() {
        return "/WEB-INF/index.jsp";
    }

    @RequestMapping("/index")
    public String index(){
        return "WEB-INF/index.jsp";
    }
}
