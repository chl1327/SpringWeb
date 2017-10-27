package org.fkit.vo;

import org.fkit.domain.Book;

import java.util.Date;

/**
 * Created by chl1327 on 2017/7/1.
 */

public class BookVo {
    private String id;				// id
    private String name;			// 书名
    private String author;			// 作者
    private String publication;		// 出版社
    private Date publicationdate;	// 出版日期
    private Double price;			// 价格
    private String image;			// 封面图片
    private String remark;
    //private UserVo userVo;
    public UserVo userVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Date getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static BookVo fromBook(Book book){
        BookVo bookVo = new BookVo();
        bookVo.setId(book.getId());
        bookVo.setName(book.getName());
        bookVo.setAuthor(book.getAuthor());
        bookVo.setPublication(book.getPublication());
        bookVo.setPublicationdate(book.getPublicationdate());
        bookVo.setPrice(book.getPrice());
        bookVo.setImage(book.getImage());
        bookVo.setRemark(book.getRemark());
        return bookVo;
    }
}
