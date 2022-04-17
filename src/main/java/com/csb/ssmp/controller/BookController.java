package com.csb.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.csb.ssmp.controller.utils.R;
import com.csb.ssmp.domain.Book;
import com.csb.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        return new R(flag);
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        // 如果当前页码大于总页码值，重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }



}
