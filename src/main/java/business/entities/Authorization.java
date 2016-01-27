package business.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import business.utils.Role;

@Entity
public class Authorization {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private User user;

    private Role role;

    public Authorization() {
    }

    public Authorization(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return id == ((Authorization) obj).id;
        }
    }

    @Override
    public String toString() {
        return "Authorization [id=" + id + ", userId=" + user.getId() + ", role=" + role + "]";
    }

}
