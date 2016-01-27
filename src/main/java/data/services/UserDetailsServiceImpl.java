package data.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import data.daos.AuthorizationDao;
import data.daos.TokenDao;
import data.daos.UserDao;
import business.entities.User;
import business.utils.Role;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorizationDao authorizationDao;

    @Autowired
    private TokenDao tokenDao;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        String password;
        User user = tokenDao.findUserByValue(username);
        if (user == null) {
            user = userDao.findDistinctByUsernameOrEmail(username, username);
            if (user == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            } else {
                password = user.getPassword();
            }
        } else {
            password = new BCryptPasswordEncoder().encode(user.getUsername());
        }
        List<Role> roleList = authorizationDao.findRoleByUser(user);
        return this.userBuilder(user.getUsername(), password, roleList);
    }

    private org.springframework.security.core.userdetails.User userBuilder(String username, String password, List<Role> roles) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.roleName()));
        }
        return new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
    }
}
