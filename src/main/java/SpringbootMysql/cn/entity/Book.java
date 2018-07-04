package SpringbootMysql.cn.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create by zhouchengchao on 2018/7/3
 */

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue
    private  Integer id;
    private  String name;
    private  int type;
    private  String author;
    private  double price;
    private  String message;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", message='" + message + '\'' +
                '}';
    }
}
