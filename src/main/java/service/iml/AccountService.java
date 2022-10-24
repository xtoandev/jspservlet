package service.iml;

import dao.IAccountDAO;
import dao.iml.AccountDAO;
import model.AccountModel;
import service.IAccountService;

public class AccountService implements IAccountService {

    private IAccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    @Override
    public AccountModel getAccountByEmailAndPassword(String email, String password) {
        return accountDAO.getAccountByEmailAndPassword(email,password);
    }
}
