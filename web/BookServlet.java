package com.bookStore.web;

import com.bookStore.pojo.Book;
import com.bookStore.pojo.Page;
import com.bookStore.service.BookService;
import com.bookStore.service.impl.BookServiceImpl;
import com.bookStore.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, ServletException, IOException {
        /**
         * 1获取请求的参数--封装成bean对象
         * 2调用bookService.addBook()保存图书
         * 3跳转到图书页面的列表
         */
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        //跳转页面重定向
      //  resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 就是删除图书的id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.deleteBookById()方法删除图书
        bookService.deleteBookById(id);
        //请求重定向转回图书列表管理
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException {
        req.setCharacterEncoding("utf-8");
        //获取请求的参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        // 调用bookService.updateBook()修改图书*/
        bookService.updateBook(book);
        //跳转页面重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的图书参数的编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookSerivce.queryBook查询图书
        Book book = bookService.queryBookById(id);
        //保存到图书的request域中
        req.setAttribute("book",book);
        //请求转发 pages/manager/book_editor页面
        req.getRequestDispatcher("/pages/manager/book_editor.jsp").forward(req,resp);
    }
    //列表页面实现数据
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //把全部图书保存到Request域中
        req.setAttribute("books",books);
        //请求转发到/pages/manager/book_manager页面
        req.getRequestDispatcher("/pages/manager/manager_book.jsp").forward(req,resp);
    }

    /**
     * 处理分页的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
   /* protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取请求的参数pageNo and pageSize
    int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
    int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    //调用BookService.page(pageNo,pageSize)方法 page对象
    Page<Book> page = bookService.page(pageNo,pageSize);

    //保存page对象到request域中
        req.setAttribute("page",page);
        //请求转发到/pages/manager/manager_book.jsp
        req.getRequestDispatcher("/pages/manager/manager_book.jsp").forward(req,resp);
    }*/

}
