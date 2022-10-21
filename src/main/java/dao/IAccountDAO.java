package dao;

import model.AccountModel;

public interface IAccountDAO {
    AccountModel getAccountByEmailAndPassword(String email,String password);
}
