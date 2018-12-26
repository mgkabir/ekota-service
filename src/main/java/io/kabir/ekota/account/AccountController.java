package io.kabir.ekota.account;

import io.kabir.ekota.account.service.AccountService;
import io.kabir.ekota.user.Role;
import io.kabir.ekota.user.User;
import io.kabir.ekota.user.service.UserService;
import io.kabir.ekota.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ekota")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;

    /*
     * SYS_ADMIN gets ALL accounts. TENANT_ADMIN gets accounts that belong to own Tenant
     */
    @GetMapping("/accounts")
    public ResponseEntity getAllAccounts(Principal principal) {
        List<Role> roles = userService.findByUsername(principal.getName()).getRoles();
        boolean isSysAdmin = roles.stream().anyMatch(role -> role.getRoleName().equals(Role.ROLE_SYS_ADMIN));
        if (isSysAdmin) return new ResponseEntity(accountService.findAllAccounts(), HttpStatus.OK);
        boolean isTenantAdmin = roles.stream().anyMatch(role -> role.getRoleName().equals(Role.ROLE_TENANT_ADMIN));
        if ((isTenantAdmin)) {
            Long tenantId = userService.findByUsername(principal.getName()).getTenant().getId();
            return new ResponseEntity(accountService.findAccountByTenantId(tenantId), HttpStatus.OK);
        }
        return new ResponseEntity(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{tenantId}")
    public ResponseEntity<List<Account>> getAccountsByTenant(@PathVariable("tenantId") String tenantId) {
        return new ResponseEntity<>(accountService.findAccountByTenantId(Long.parseLong(tenantId)), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> saveAccount(@RequestBody AccountPayLoad payLoad, Principal principal) {
        Account account = new Account(payLoad.getName(), payLoad.getMobileNumber());
        User user = userService.findByUsername(principal.getName());
        account.getTenant().setId(user.getTenant().getId());
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.OK);
    }
}
