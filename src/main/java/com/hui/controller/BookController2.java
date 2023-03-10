package com.hui.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hui.pojo.Book;
import com.hui.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Resource
    private BookService bookService;

    //查询全部数据列表
    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    //添加一条数据
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    //修改数据
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    //删除一条数据
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    //查询一条数据
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    //分页查询
    @GetMapping("/page/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        return bookService.getPage(currentPage,pageSize);
    }

}
