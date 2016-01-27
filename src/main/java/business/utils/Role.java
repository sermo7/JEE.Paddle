package business.utils;

public enum Role {
    ADMIN, PLAYER, TRAINER;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}
