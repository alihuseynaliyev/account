package com.alinazim.account.dao.repository;

import com.alinazim.account.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
