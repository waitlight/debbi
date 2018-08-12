package org.dl.debbi.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.Assert;
import org.dl.debbi.user.domain.Account;
import org.dl.debbi.user.repo.AccountRepository;
import org.dl.debbi.user.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepo;

    @Before
    public void before() {
        accountService.register("wangxiaoming", "123321");
    }

    @After
    public void after() {
        Optional<Account> accountOpt = accountRepo.getByPrincipal("wangxiaoming");
        assert accountOpt.isPresent();
        accountRepo.cleanup(accountOpt.get().id);
    }

    @Test
    public void auth() {
        Account account = accountService.auth("wangxiaoming", "123321");
        Assert.notNull(account);
    }
}