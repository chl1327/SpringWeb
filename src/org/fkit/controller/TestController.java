package org.fkit.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.fkit.domain.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


/**
 * @Description:
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0
 */
@Controller
@RequestMapping("/json")
public class TestController {

    private static final Log logger = LogFactory.getLog(BookController.class);

    // @RequestBody根据json数据，转换成对应的Object
    @RequestMapping(value="/setJson",method = RequestMethod.POST)
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws Exception{
        // ObjectMapper类是Jackson库的主要类。它提供一些功能将Java对象转换成对应的JSON格式的数据
        // 将book对象转换成json输出
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(book));
        book.setAuthor("肖文吉");
        System.out.println(book);
        response.setContentType("text/html;charset=UTF-8");
        // 将book对象转换成json写出到客户端
        response.getWriter().println(mapper.writeValueAsString(book));
    }

}
