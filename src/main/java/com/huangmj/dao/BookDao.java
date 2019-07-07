package com.huangmj.dao;

import com.huangmj.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BookDao {

    /**
     * 通过ID查询单本图书
     *
     * @param bookId
     * @return
     */
    @Select("select book_id,name,number form book where book_id = #{bookId}")
    Book queryById(long bookId);
    /**
     * 查询所有图书
     * SQL语句中的LIMIT关键字用于限制查询条数
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    @Select("select book_id,name,number from book order by book_id LIMIT #{offset}, #{limit}")
    List<Book> queryAll(int offset, int limit);
    /**
     * 减少馆藏数量
     * @param bookId
     * @return
     */
    @Update("update book set number = number-1 where book_id = #{bookId} and number > 0")
    int reduceNumber(long bookId);
}
