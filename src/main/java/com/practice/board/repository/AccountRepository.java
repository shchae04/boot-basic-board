package com.practice.board.repository;

import com.practice.board.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByUsername(String username);

}
