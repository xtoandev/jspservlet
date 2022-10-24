package mapper;

import model.BookModel;
import model.CategoryModel;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

public class BookMapper implements RowMapper<BookModel> {

    @Override
    public BookModel mapRow(ResultSet rs) {
        BookModel book = new BookModel();
        CategoryModel category = new CategoryModel();

        try {
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setDescription(rs.getString("description"));
            book.setContent(rs.getString("content"));
            BigDecimal decimal = rs.getBigDecimal("price");
            book.setPrice(decimal.toString());
            book.setBackground(rs.getString("background"));
            Date date = rs.getDate("create_date");
            String strDate = dateFormat.format(date);
            book.setCreateDate(strDate);
            book.setStatus(rs.getInt("status"));
            //setcategory
            category.setId(rs.getLong("category_id"));
            category.setCategoryName(rs.getString("category_name"));
            book.setCategory(category);

            return book;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
