package mapper;

import model.AccountModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<AccountModel> {

    @Override
    public AccountModel mapRow(ResultSet rs) {
        AccountModel tk = new AccountModel();
        try {
            tk.setId(rs.getLong("id"));
            tk.setEmail(rs.getString("email"));
            tk.setPassword(rs.getString("password"));
            tk.setRoleID(rs.getLong("role_id"));
            tk.setFullName(rs.getString("full_name"));
            tk.setAvatar(rs.getString("avatar"));
            tk.setStatus(rs.getInt("status"));
            //tk.setCreateDate(rs.getDa("status"));

            return tk;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
