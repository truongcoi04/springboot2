package com.vti.rw41.Repository;

import com.vti.rw41.Entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    @Query("SELECT (count(a) = 0) from AccountEntity a where a.email = :email")
    boolean isEmailNotExists(String email);

    List<AccountEntity> findByFullNameLike(String name);
    // select * from account where fullname like = ?
    //                  findByFullNameContaining(String name);

    @Query("FROM AccountEntity where fullName like %:name%")
    List<AccountEntity> timAccountTheoTen(String name);

    @Transactional
    @Modifying
    @Query("update AccountEntity set fullName = :name where id = :id")
    int updateNameById(String name, Integer id);



    AccountEntity findByEmailOrPhoneNumber(String email, String phoneNumber);
}
