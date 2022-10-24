package mapper;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface RowMapper<T> {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    T mapRow(ResultSet rs);


}
