package SpringbootMysql.cn.controller;

import SpringbootMysql.cn.dao.BookRespository;
import SpringbootMysql.cn.dao.imp.BookDao;
import SpringbootMysql.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * create by zhouchengchao on 2018/7/4
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookDao bookDao;

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return  bookDao.getAll();
    }

    @RequestMapping("/getByNameLike")
    public List<Book> getBookByNameLike(@RequestBody String nameLike){
        System.out.println(nameLike);
        return bookDao.findBooksByNameLike(nameLike);

    }

    @PostMapping("/getByNameLikeAndPriceBetween")
    public List<Book> getByNameLikeAndPriceBetween(@RequestBody Map map){
        System.out.println(map.get("lowPrice"));
        String nameLike= String.valueOf((map.get("nameLike")));
        double lowPrice= Double.parseDouble(String.valueOf(map.get("lowPrice")));
        double highPrice=Double.parseDouble(String.valueOf(map.get("highPrice")));
        return bookDao.findBooksByNameLikeAndAndPriceBetween(nameLike,lowPrice,highPrice);

    }

    @PostMapping("/getById")
    public Book getById(@RequestBody Book book){
        return bookDao.findById(book);
    }

    @PostMapping("addone")
    public  void addone(@RequestBody Book book) {
        bookDao.saveone(book);
    }

    @PostMapping("deletone")
    public  void  deleteone(@RequestBody Book book){
        bookDao.delete(book);
    }

    @PostMapping("saveone")
    public  void  saveone(@RequestBody Book book){
        bookDao.saveone(book);
    }

}
