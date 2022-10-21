package model;

import mapper.RowMapper;

public class RoleModel extends RowMapper.AbstractModel {
    String role_name;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public RoleModel(String role_name) {
        this.role_name = role_name;
    }

    public RoleModel() {
    }
}
