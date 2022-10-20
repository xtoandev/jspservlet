package model;

import mapper.RowMapper;

public class AccountModel extends RowMapper.AbstractModel {

    private String password;
    private Long roleID;
    private String fullName;
    private String Dob;
    private String email;
    private String avatar;

    public AccountModel() {
    }

    public AccountModel(String password, Long roleID, String fullName, String dob, String email, String avatar) {
        this.password = password;
        this.roleID = roleID;
        this.fullName = fullName;
        Dob = dob;
        this.email = email;
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
