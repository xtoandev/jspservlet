package service.iml;

import dao.IBookDAO;
import dao.iml.BookDAO;
import model.BookModel;
import service.IBookService;

import java.util.List;

public class BookService implements IBookService {

    private IBookDAO bookDAO = new BookDAO();
    @Override
    public List<BookModel> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public BookModel findOne(Long id) {

        return bookDAO.findOne(id);
    }

    @Override
    public BookModel save(BookModel book) {
        Long newID = bookDAO.save(book);
        return bookDAO.findOne(newID);
    }

    @Override
    public void update(BookModel book) {
        bookDAO.update(book);

    }

    @Override
    public void delete(Long id) {

            bookDAO.delete(id);

    }
}
