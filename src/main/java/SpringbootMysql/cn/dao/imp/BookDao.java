package SpringbootMysql.cn.dao.imp;

import SpringbootMysql.cn.dao.BookRespository;
import SpringbootMysql.cn.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * create by zhouchengchao on 2018/7/4
 */
@Component
public class BookDao  {
    @Autowired
    BookRespository bookRespository;

    public List<Book> findBooksByNameLike(String nameLike) {
        return  bookRespository.findBooksByNameLike("%"+nameLike+"%");
    }


    public List<Book> findBooksByNameLikeAndAndPriceBetween(String nameLike, double lowprice, double highprice) {
        return bookRespository.findBooksByNameLikeAndAndPriceBetween("%"+nameLike+"%",lowprice,highprice);
    }


    public List<Book> getAll() {
        return bookRespository.findAll();
    }

    //    不太正常，应该返回一个信息
    public void saveone(Book book){
        bookRespository.save(book);
    }

//    不太正常，应该返回一个信息 ,add 和 update都使用save
    public void saveList(List<Book> bookList){
        bookRespository.saveAll(bookList);
    }


    public void  insertone(Book book){
        bookRespository.insert(book.getAuthor(),book.getMessage(),book.getName(),book.getPrice(),book.getType());
    }
//

   public  void  delete(Book book){
         bookRespository.delete(book);
   }

//
    public Book findById(Book book){
        return bookRespository.findBookById(book.getId());
    }


}
