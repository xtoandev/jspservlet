package service;

import model.AbstractModel;
import model.AccountModel;

public interface IAccountService {
    AccountModel getAccountByEmailAndPassword(String email, String password);
}
