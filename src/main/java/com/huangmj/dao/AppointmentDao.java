package com.huangmj.dao;

import com.huangmj.entity.Appointment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface AppointmentDao {

	/**
	 * 插入预约图书记录
	 * 
	 * @param bookId 预约图书的ID
	 * @param studentId  预约学生的ID
	 * @return 插入的行数
	 */
	@Insert("INSERT ignore INTO appointment (book_id, student_id VALUES (#{bookId}, #{studentId})")
	int insertAppointment(long bookId, long studentId);

	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	@Select("select a.book_id,a.student_id,a.appoint_time,\n" +
            "b.book_id \"book.book_id\",b.name \"book.name\",b.number \"book.number\"\n" +
            "from\n" +
            "    appointment a\n" +
            "inner join book b on a.book_id = b.book_id\n" +
            "where a.book_id = #{bookId}\n" +
            "and a.student_id = #{studentId}")
	Appointment queryByKeyWithBook(long bookId, long studentId);
}
