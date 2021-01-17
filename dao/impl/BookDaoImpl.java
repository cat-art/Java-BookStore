package com.bookStore.dao.impl;

import com.bookStore.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
    String sql = "insert into t_book(name,price,author,sales,stock,img_path) values (?,?,?,?,?,?)";
        return insert_Delete_Update(sql,book.getName(),book.getPrice(),book.getAuthor(),
                book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=?";
        return insert_Delete_Update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return insert_Delete_Update(sql,book.getName(),book.getPrice(),book.getAuthor(),
                book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book>  queryBooks() {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book";
        return queryForList(Book.class,sql);
    }


   /* @Override
    public Integer queryPageTotalCount() {
        String sql="select count(*) from t_book";
        Number count = (Number) queryForSingValue(sql);
        return  count.intValue();
    }


    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
       String sql = "  SELECT  rownum AS id,name,price,author,sales,stock\n" +
               "FROM(\n" +
               "    SELECT rownum AS id,name,price,author,sales,stock\n" +
               "    FROM(\n" +
               "        SELECT id,name,price,author,sales,stock FROM t_book\n" +
               "    )\n" +
               ") a\n" +
               "WHERE a.id between ? and ?";
       //String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }*/

}

