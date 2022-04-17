package com.csb.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csb.ssmp.domain.Book;
import com.csb.ssmp.mapper.BookMapper;
import com.csb.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean modify(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean saveBook(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(!Strings.isEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(!Strings.isEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(!Strings.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookMapper.selectPage(page,lqw);
        return page;
    }
}
