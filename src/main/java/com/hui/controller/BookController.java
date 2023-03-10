package com.hui.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hui.pojo.Book;
import com.hui.service.BookService;
import com.hui.controller.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookService;

    //查询全部数据列表
    @GetMapping
    public R getAll(){
        return new R(true,bookService.getAll());
    }

    //添加一条数据
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        Boolean flag = bookService.save(book);
        //if (book.getName().equals("123")) throw new IOException();
        return new R(flag,flag ? "添加成功^_^" : "添加失败-_-!");
    }

    //修改数据
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    //删除一条数据
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    //查询一条数据
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    //分页查询
    @GetMapping("/page/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Book> pageBook = bookService.getPage(currentPage, pageSize);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大码值作为当前页码值
        if (currentPage > pageBook.getPages()){
            pageBook = bookService.getPage((int) pageBook.getPages(),pageSize);
        }
        return new R(pageBook != null,pageBook);
    }

    //@GetMapping("/pages/{currentPage}/{pageSize}")
    //public R getPageMax(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
    //    IPage<Book> pageBook = bookService.getPage(currentPage, pageSize);
    //    //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大码值作为当前页码值
    //    if (currentPage < pageBook.getPages()){
    //        pageBook = bookService.getPage((int) pageBook.getPages(),pageSize);
    //    }
    //    return new R(pageBook != null,pageBook);
    //}

}
