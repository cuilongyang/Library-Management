package com.csb.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csb.ssmp.domain.Book;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
public interface IBookService extends IService<Book> {
    boolean modify(Book book);
    boolean saveBook(Book book);
    boolean delete(Integer id);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize,Book book);
}
