package com.vti.rw41.Repository;

import com.vti.rw41.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    @Query("SELECT (count(a) = 0) from AccountEntity a where a.email = :email")
    boolean isEmailNotExists(String email);

}
