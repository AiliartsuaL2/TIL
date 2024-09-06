package section5.item26.genericdao;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
    @Test
    void findById() {
        AccountRepository accountRepository = new AccountRepository();
        Account ailiartsua = new Account(1L, "ailiartsua");
        accountRepository.add(ailiartsua);

        Optional<Account> byId = accountRepository.findById(1L);
        assertTrue(byId.isPresent());
    }
}