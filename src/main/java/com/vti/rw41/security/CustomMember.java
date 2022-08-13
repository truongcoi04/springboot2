//package com.vti.rw41.security;
//
//import com.vti.rw41.Entity.AccountEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//public class CustomMember implements UserDetails {
//
//    private final AccountEntity account;
//
//    public CustomMember(AccountEntity account) {
//        this.account = account;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {  // -> quyền của account
//        return List.of(new SimpleGrantedAuthority(account.getRole().toString()));
//    }
//
//    @Override
//    public String getPassword() {
//        return account.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return account.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {   // -> user này đã hết hạn chưa
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {   // -> user này có bị lock không
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {   // user này có chưa hết hạn không
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {   // user này có enabled không
//        return true;
//    }
//}
