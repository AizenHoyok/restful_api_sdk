package com.xlwansdk.pojo.db;

import javax.persistence.*;

@Table(name = "tab_role")
public class GameRole {
    @Id
    private Integer id;

    /**
     * 推广员工
     */
    private Integer inv;

    /**
     * 推广游戏
     */
    @Column(name = "invGame")
    private String invgame;

    /**
     * 游戏区服
     */
    private String server;

    /**
     * 角色创建时间
     */
    @Column(name = "regTime")
    private Integer regtime;

    /**
     * 角色创建IP
     */
    @Column(name = "regIp")
    private String regip;

    /**
     * 上次登录时间
     */
    @Column(name = "lastTime")
    private Integer lasttime;

    /**
     * 上次离开游戏时间
     */
    @Column(name = "lastExitTime")
    private Integer lastexittime;

    /**
     * 上次登录IP
     */
    @Column(name = "lastIp")
    private String lastip;

    /**
     * 所属分组
     */
    private Integer bgroup;

    /**
     * 所属分部
     */
    private Integer bid;

    /**
     * 角色名称
     */
    private String nick;

    /**
     * 角色等级
     */
    private Integer level;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取推广员工
     *
     * @return inv - 推广员工
     */
    public Integer getInv() {
        return inv;
    }

    /**
     * 设置推广员工
     *
     * @param inv 推广员工
     */
    public void setInv(Integer inv) {
        this.inv = inv;
    }

    /**
     * 获取推广游戏
     *
     * @return invGame - 推广游戏
     */
    public String getInvgame() {
        return invgame;
    }

    /**
     * 设置推广游戏
     *
     * @param invgame 推广游戏
     */
    public void setInvgame(String invgame) {
        this.invgame = invgame;
    }

    /**
     * 获取游戏区服
     *
     * @return server - 游戏区服
     */
    public String getServer() {
        return server;
    }

    /**
     * 设置游戏区服
     *
     * @param server 游戏区服
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * 获取角色创建时间
     *
     * @return regTime - 角色创建时间
     */
    public Integer getRegtime() {
        return regtime;
    }

    /**
     * 设置角色创建时间
     *
     * @param regtime 角色创建时间
     */
    public void setRegtime(Integer regtime) {
        this.regtime = regtime;
    }

    /**
     * 获取角色创建IP
     *
     * @return regIp - 角色创建IP
     */
    public String getRegip() {
        return regip;
    }

    /**
     * 设置角色创建IP
     *
     * @param regip 角色创建IP
     */
    public void setRegip(String regip) {
        this.regip = regip;
    }

    /**
     * 获取上次登录时间
     *
     * @return lastTime - 上次登录时间
     */
    public Integer getLasttime() {
        return lasttime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lasttime 上次登录时间
     */
    public void setLasttime(Integer lasttime) {
        this.lasttime = lasttime;
    }

    /**
     * 获取上次离开游戏时间
     *
     * @return lastExitTime - 上次离开游戏时间
     */
    public Integer getLastexittime() {
        return lastexittime;
    }

    /**
     * 设置上次离开游戏时间
     *
     * @param lastexittime 上次离开游戏时间
     */
    public void setLastexittime(Integer lastexittime) {
        this.lastexittime = lastexittime;
    }

    /**
     * 获取上次登录IP
     *
     * @return lastIp - 上次登录IP
     */
    public String getLastip() {
        return lastip;
    }

    /**
     * 设置上次登录IP
     *
     * @param lastip 上次登录IP
     */
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    /**
     * 获取所属分组
     *
     * @return bgroup - 所属分组
     */
    public Integer getBgroup() {
        return bgroup;
    }

    /**
     * 设置所属分组
     *
     * @param bgroup 所属分组
     */
    public void setBgroup(Integer bgroup) {
        this.bgroup = bgroup;
    }

    /**
     * 获取所属分部
     *
     * @return bid - 所属分部
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置所属分部
     *
     * @param bid 所属分部
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取角色名称
     *
     * @return nick - 角色名称
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置角色名称
     *
     * @param nick 角色名称
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取角色等级
     *
     * @return level - 角色等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置角色等级
     *
     * @param level 角色等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", inv=").append(inv);
        sb.append(", invgame=").append(invgame);
        sb.append(", server=").append(server);
        sb.append(", regtime=").append(regtime);
        sb.append(", regip=").append(regip);
        sb.append(", lasttime=").append(lasttime);
        sb.append(", lastexittime=").append(lastexittime);
        sb.append(", lastip=").append(lastip);
        sb.append(", bgroup=").append(bgroup);
        sb.append(", bid=").append(bid);
        sb.append(", nick=").append(nick);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}