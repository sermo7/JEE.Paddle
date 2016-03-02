package spike;

import business.entities.Role;

public class PruebaRole {

    public static void main(String[] args) {
        Role role = Role.ADMIN;
        System.out.println(">>" + role + "<");
        System.out.println(">>" + role.roleName() + "<");
    }

}
