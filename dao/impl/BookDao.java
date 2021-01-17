package com.bookStore.dao.impl;

import com.bookStore.pojo.Book;

import java.util.List;

public interface BookDao {

    public int addBook(Book book) ;

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

  /*  List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryPageTotalCount();*/
}
