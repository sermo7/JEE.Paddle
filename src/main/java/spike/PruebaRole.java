package spike;

import business.utils.Role;

public class PruebaRole {

    public static void main(String[] args) {
        Role role = Role.ADMIN;
        System.out.println(">>" + role + "<");
        System.out.println(">>" + role.roleName() + "<");
    }

}
