package io.kabir.ekota.account.service;

import io.kabir.ekota.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAccountByTenantId(Long tenantId) {
        return accountRepository.findAccountsByTenantId(tenantId);
    }

    @Override
    public List<Account> findAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
