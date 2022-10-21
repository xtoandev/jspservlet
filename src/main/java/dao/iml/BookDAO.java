package dao.iml;

import dao.IBookDAO;
import mapper.BookMapper;
import model.BookModel;

import java.util.List;

public class BookDAO extends AbstractDAO<BookModel> implements IBookDAO {

    @Override
    public List<BookModel> findAll() {
        String sql = "Select * From book "+
                    " LEFT JOIN category" +
                    " ON book.category_id = category.id" ;

                List<BookModel> list = query(sql ,new BookMapper());
        return list;
    }

    @Override
    public BookModel findOne(Long id) {

        String sql = "Select * From book " +
                    " LEFT JOIN category " +
                    " ON book.category_id = category.id " +
                    " where book.id = ?";
        List<BookModel> dstk = query(sql, new BookMapper(),id);
        return dstk.isEmpty() ? null : dstk.get(0);
    }

    @Override
    public Long save(BookModel book) {
        String sql = "insert into book (title, category_id, description, content, background, create_date, status)" +
                "values(?,?,?,?,?,?,?) ";
        return insert(sql,book.getTitle()
                , book.getCategoryID()
                , book.getDescription()
                , book.getContent()
                , book.getBackground()
                , book.getCreateDate()
                , book.getStatus());
    }

    @Override
    public void update(BookModel book) {

        String sql = "update book SET "
                + " title = ? "
                + ", category_id = ? "
                + ", description = ? "
                + ", content = ? "
                + ", background = ? "
                + ", create_date = ?"
                + ", status = ?" +
                " WHERE id = ? ; ";
        update(sql,book.getTitle()
                , book.getCategoryID()
                , book.getDescription()
                , book.getContent()
                , book.getBackground()
                , book.getCreateDate()
                , book.getStatus()
                , book.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM book WHERE id = ?";
        update(sql,id);
    }
}
