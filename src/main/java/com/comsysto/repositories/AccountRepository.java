package com.comsysto.repositories;

import com.comsysto.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sekibomazic
 */
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

}