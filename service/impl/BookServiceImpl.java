package com.bookStore.service.impl;

import com.bookStore.dao.impl.BookDao;
import com.bookStore.dao.impl.BookDaoImpl;
import com.bookStore.pojo.Book;
import com.bookStore.pojo.Page;
import com.bookStore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

   /* @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //设置当前的页码
        page.setPageNo(pageNo);
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总的记录数
        Integer pageTotalCount = bookDao.queryPageTotalCount();
        //求总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页的数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页的数据
        page.setItem(items);
        return page;
    }*/
}
















