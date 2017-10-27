package org.fkit.service;

import org.fkit.domain.Book;
import java.util.List;
/**
 * Created by 心痕 on 2017-6-29.
 */
public interface BookService {
    /**
     * 查找所有图书
     * @return Book对象集合
     * */
    List<Book> getAll();

    /**
     * 根据ID查找图书
     * @return Book对象
     * */
    Book selectOneBook(String id);
}
