package com.hui.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hui.pojo.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean updateById(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);

}
