package dao;

import model.BookModel;

import java.util.List;

public interface IBookDAO {
    List<BookModel> findAll();
    BookModel findOne(Long id);
    Long save(BookModel book);
    void update(BookModel book);
    void delete(Long id);
}
