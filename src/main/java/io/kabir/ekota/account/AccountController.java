package io.kabir.ekota.account;

import io.kabir.ekota.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ekota")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/accounts/{tenantId}")
    public List<Account> getAccountsByTenant(@PathVariable("tenantId") String tenantId) {
        return accountService.findAccountByTenantId(Long.parseLong(tenantId));
    }
}
