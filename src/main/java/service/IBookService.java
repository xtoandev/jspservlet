package service;

import model.BookModel;

import java.util.List;

public interface IBookService {
    List<BookModel> findAll();
    BookModel findOne(Long id);
    BookModel save(BookModel book);
    void update(BookModel book);
    void delete(Long ids);
}
