package org.fkit.controller;

import org.fkit.domain.Book;
import org.fkit.service.BookService;
import org.fkit.service.UserService;
import org.fkit.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 心痕 on 2017-6-29.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /*@RequestMapping(value = "/main")
    public String main(Model model){
        List<Book> book_list = bookService.getAll();
        model.addAttribute("book_list",book_list);
        return "main";
    }*/
    @ResponseBody
    @RequestMapping(value = "/main/{method}",method = RequestMethod.GET)
    public Map<String,Object> main(@PathVariable String method,HttpSession session){
        HashMap map = new HashMap();
        String LoginId = (String)session.getAttribute("CASTGC");
        if (userService.isLogin(LoginId) == null){
            map.put("error","未注册或登录用户请先注册登录！");
            return map;
        }else{
            map.put("userVo",userService.isLogin(LoginId));
        }
        List<BookVo> bookVos = new ArrayList<>();
        List<Book> book_list = bookService.getAll();
        if (method.equals("list")){
            if (!book_list.isEmpty()){
                for (Book book: book_list){
                    bookVos.add(BookVo.fromBook(book));
                }
                map.put("data",bookVos);
                map.put("success",Boolean.valueOf(true));
            }else {
                map.put("error", Boolean.valueOf(false));
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/selectBook/{id}",method = RequestMethod.GET)
    public Map<String,Object> selectBook(@PathVariable String id){

        HashMap map = new HashMap();
        Book book = new Book();
        BookVo bookVo = new BookVo();
        if (id != null) {
            book = bookService.selectOneBook(id);
            if (book != null){
                bookVo = BookVo.fromBook(book);
                map.put("data",bookVo);
                map.put("success",Boolean.valueOf(true));
            }
        }else{
            map.put("error", Boolean.valueOf(false));
        }
        return map;
    }

}
