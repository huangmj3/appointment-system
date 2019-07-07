package com.huangmj.dao;

import com.huangmj.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class BookDaoTest {
//    @Autowired
//    private BookDao bookDao;

    @Test
    public void queryById() {
        long bookId = 1000;
//        Book book = bookDao.queryById(bookId);
//        System.out.println(book);
        System.out.println(bookId);
    }

//    @Test
//    public void queryAll() {
//        List<Book> books = bookDao.queryAll(0,4);
//        for(Book book : books){
//            System.out.println(book);
//        }
//    }
//
//    @Test
//    public void reduceNumber() {
//        long bookId = 1000;
//        int update = bookDao.reduceNumber(bookId);
//        System.out.println("update" + update);
//    }
}