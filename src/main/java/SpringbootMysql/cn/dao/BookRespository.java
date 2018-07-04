package SpringbootMysql.cn.dao;

import SpringbootMysql.cn.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by zhouchengchao on 2018/7/3
 */
public interface BookRespository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByNameLike(String name);

    List<Book> findBooksByNameLikeAndAndPriceBetween(String nameLike,double lowprice,double highprice);

    List<Book> findAll();

    Book findBookById(int id);

    @Modifying
    @Transactional
    @Query(value = "insert into book book (author, message, name, price, type) values (?1, ?2, ?3, ?4, ?5)",nativeQuery = true)
    void  insert(String author,String message,String name ,double price,int type);

}
