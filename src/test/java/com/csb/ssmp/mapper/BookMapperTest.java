package com.csb.ssmp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csb.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testById(){
        System.out.println(bookMapper.selectById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("UCA");
        book.setName("UCA计算机");
        book.setDescription("克莱蒙费朗大学计算机");
        bookMapper.insert(book);
    }
    @Test
    void testDelete(){
        bookMapper.deleteById(3);
    }
    @Test
    void testGetAll(){
        List<Book> books = bookMapper.selectList(null);
        System.out.println(books);
    }
    @Test
    void testGetPage(){
        IPage iPage = new Page(1,2);
        bookMapper.selectPage(iPage,null);
        System.out.println(iPage.getRecords());
    }
    @Test
    void testGetBy(){

        String name = null;
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(name!=null,Book::getName,name);
        bookMapper.selectList(qw);

    }
}
