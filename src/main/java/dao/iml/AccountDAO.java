package dao.iml;

import dao.IAccountDAO;
import mapper.AccountMapper;
import model.AccountModel;

import java.util.List;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO {

    @Override
    public AccountModel getAccountByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM account " +
                "LEFT JOIN role ON account.role_id = role.id"+
                " WHERE email = ? and password = ?";

        List<AccountModel> user = query(sql,new AccountMapper(),email,password);
        return user.isEmpty() ? null : user.get(0);
    }
}
