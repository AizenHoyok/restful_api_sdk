package com.xlwansdk.pojo.vo;

/**
 * 玩家视图层实体类
 * @author Liu YuJie
 * @date 2018-01-24 13:55:31
 */
public class MemberVo {
    /**
     * 主键 MySQL自增ID 唯一
     */
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * Token 凭证
     */
    private String token;

    @Override
    public String toString() {
        return "MemberVo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
