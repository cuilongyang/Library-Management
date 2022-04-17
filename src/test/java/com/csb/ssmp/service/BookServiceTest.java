package com.csb.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csb.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(2));
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setType("测试");
        book.setName("测试入门");
        book.setDescription("测试的入门教材");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        bookService.removeById(4);
    }

    @Test
    void testGetALL(){
        bookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(1,3);
        bookService.page(page);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
