package io.kabir.ekota.account;

import io.kabir.ekota.account.service.AccountService;
import io.kabir.ekota.user.User;
import io.kabir.ekota.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/ekota")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/accounts/{tenantId}")
    public List<Account> getAccountsByTenant(@PathVariable("tenantId") String tenantId) {
        return accountService.findAccountByTenantId(Long.parseLong(tenantId));
    }

    @PostMapping("/accounts")
    public void saveAccount(@RequestBody AccountPayLoad payLoad, Principal principal){
        Account account = new Account(payLoad.getName(), payLoad.getMobileNumber());
        User user = userService.findByUsername(principal.getName());

        System.out.println(" user  "+user.getFirstName() +" tenant "+user.getTenant().getName());

        account.getTenant().setId(user.getTenant().getId());
        accountService.saveAccount(account);
    }
}
