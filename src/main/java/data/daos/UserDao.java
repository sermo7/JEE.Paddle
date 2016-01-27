package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    public User findDistinctByUsernameOrEmail(String username, String email);

}
