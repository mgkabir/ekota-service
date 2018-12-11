package io.kabir.ekota.account.service;

import io.kabir.ekota.account.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountByTenantId(Long tenantId);

    List<Account> findAllAccounts();
}
