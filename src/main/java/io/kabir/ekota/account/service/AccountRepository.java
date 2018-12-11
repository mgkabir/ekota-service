package io.kabir.ekota.account.service;

import io.kabir.ekota.account.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountsByTenantId(Long tenantId);
}
