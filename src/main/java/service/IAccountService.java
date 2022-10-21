package service;

import model.AccountModel;

public interface IAccountService {
    AccountModel getAccountByEmailAndPassword(String email, String password);
}
