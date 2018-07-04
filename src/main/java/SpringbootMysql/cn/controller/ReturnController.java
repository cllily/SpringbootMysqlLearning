package SpringbootMysql.cn.controller;


import SpringbootMysql.cn.dao.imp.BookDao;
import SpringbootMysql.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * create by zhouchengchao on 2018/7/3
 */
@Controller
public class ReturnController {
    @Autowired
    BookDao bookDao;


    @RequestMapping("/index")
    String index(){
        int i=100;


        SimpleDateFormat sdf=new SimpleDateFormat();
        String name="平凡的世界";
        String author="路遥";
        String message="这是一本好书";
        int type=1;
        double price=99.99;
        Date startTime=new Date();
        while (i-->0) {
            Book book=new Book();
            book.setAuthor(author);
            book.setMessage(message);
            book.setName(name);
            book.setType(type);
            book.setPrice(price);
            bookDao.saveone(book);
//            System.out.println(i);
        }
        Date endTime=new Date();
        i=100;
        while (i-->0) {
            Book book=new Book();
            book.setAuthor(author);
            book.setMessage(message);
            book.setName(name);
            book.setType(type);
            book.setPrice(price);
            bookDao.insertone(book);
//            System.out.println(i);
        }
        Date endTime1=new Date();
        System.out.println("第一次(原生)的时间: "+(endTime.getTime()-startTime.getTime()));
        System.out.println("第二次（sql）的时间:"+(endTime1.getTime()-startTime.getTime()));
        return "index";
    }
}
