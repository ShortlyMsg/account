package com.shortlymsg.account.repository;

import com.shortlymsg.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
