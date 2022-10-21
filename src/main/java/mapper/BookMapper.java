package mapper;

import model.BookModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookMapper implements RowMapper<BookModel> {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public BookModel mapRow(ResultSet rs) {
        BookModel book = new BookModel();
        try {
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setCategoryID(rs.getLong("category_id"));
            book.setDescription(rs.getString("description"));
            book.setContent(rs.getString("content"));
            book.setBackground(rs.getString("background"));
            Date date = rs.getDate("create_date");
            String strDate = dateFormat.format(date);
            book.setCreateDate(strDate);
            book.setStatus(rs.getInt("status"));
            book.setCategoryName(rs.getString("category_name"));
            //tk.setCreateDate(rs.getDa("status"));

            return book;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
