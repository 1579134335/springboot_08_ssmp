package com.hui.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
     @Test
    void testSave(){
         Book book = new Book();
         book.setType("测试数据2");
         book.setName("测试数据2");
         book.setDescription("测试数据2");
         bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(14);
        book.setName("测试数据3");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        bookService.delete(14);
    }

    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
