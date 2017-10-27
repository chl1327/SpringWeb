package org.fkit.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Book;

import java.util.List;
/**
 * Created by 心痕 on 2017-6-29.
 */
public interface BookMapper {
    /*
    * 查询所有图书
    * @return 图书对象集合
    * */
    @Select("select * from tb_book")
    List<Book> findAll();

    /*
    * 查询单个图书
    * @return 图书对象
    * */
    @Select("select * from tb_book where id=#{id}")
    Book selectBookById(@Param("id") String id);
 }
