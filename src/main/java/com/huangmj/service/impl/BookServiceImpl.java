package com.huangmj.service.impl;

import com.huangmj.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.huangmj.entity.*;
import com.huangmj.dao.*;
import com.huangmj.exception.*;
import com.huangmj.dto.AppointExecution;
import com.huangmj.enums.AppointStateEnum;

@Service
public class BookServiceImpl implements BookService {
    //用于日志输出时候，打印出日志信息所在类
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired(required = false)
    private BookDao bookDao;

    @Autowired(required = false)
    private AppointmentDao appointmentDao;

    //通过ID去查找图书
    @Override
    public Book getById(long bookId) {
//		return bookDao.queryById(bookId);
        return bookDao.queryById(bookId);
    }
    //选择起始位置，确定查询条数
    @Override
    public List<Book> getList() {
//		return bookDao.queryAll(0, 1000);
        List<Book> list = bookDao.queryAll(0,1000);
        return list;
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            // 减库存
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0) {// 库存不足
                throw new NoNumberException("no number");
            } else {
                // 执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {// 重复预约
                    throw new RepeatAppointException("repeat appoint");
                } else {// 预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
