package com.doctorapp.model;

public enum Roles {
    ADMIN(1,"ADMIN"),USER(2,"USER");
    private int roleType;
    private String roleName;

    Roles(int roleType, String roleName) {
        this.roleType = roleType;
        this.roleName = roleName;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
