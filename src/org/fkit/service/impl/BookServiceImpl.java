package org.fkit.service.impl;

import org.fkit.domain.Book;
import org.fkit.mapper.BookMapper;
import org.fkit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * Created by 心痕 on 2017-6-29.
 */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("bookService")
public class BookServiceImpl implements BookService{
    /**
     * 自动注入BookMapper
     * */
    @Autowired
    private BookMapper bookMapper;
    /**
     * BookService接口getAll方法实现
     * @see { BookService }
     * */
    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll(){
        return bookMapper.findAll();
    }

    /**
     * 根据ID查找图书
    * @see { BookService }
    * */
    @Transactional(readOnly = true)
    @Override
    public Book selectOneBook(String id){ return bookMapper.selectBookById(id); }
}
