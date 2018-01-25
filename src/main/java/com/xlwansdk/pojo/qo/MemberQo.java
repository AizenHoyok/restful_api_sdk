package com.xlwansdk.pojo.qo;

/**
 * @author Liu YuJie
 * @date 2018-01-24 14:08:00
 */
public class MemberQo {
    private Integer id;
    private Integer inv;
    private String invGame;
    private String regTime;
    private String regIp;
    private String lastTime;
    private String lastIp;
    private Integer bgroup;
    private Integer bid;
    private Long money;
    private String mobile;
    private String pwd;
    private String mail;
    private String card;
    private String name;
    private String device;
    private String account;
    private Integer tourist;

    @Override
    public String toString() {
        return "MemberQo{" +
                "id=" + id +
                ", inv=" + inv +
                ", invGame='" + invGame + '\'' +
                ", regTime='" + regTime + '\'' +
                ", regIp='" + regIp + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", bgroup=" + bgroup +
                ", bid=" + bid +
                ", money=" + money +
                ", mobile='" + mobile + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mail='" + mail + '\'' +
                ", card='" + card + '\'' +
                ", name='" + name + '\'' +
                ", device='" + device + '\'' +
                ", account='" + account + '\'' +
                ", tourist=" + tourist +
                '}';
    }

    public MemberQo(Integer id, Integer inv, String invGame, String regTime, String regIp, String lastTime, String lastIp, Integer bgroup, Integer bid, Long money, String mobile, String pwd, String mail, String card, String name, String device, String account, Integer tourist) {
        this.id = id;
        this.inv = inv;
        this.invGame = invGame;
        this.regTime = regTime;
        this.regIp = regIp;
        this.lastTime = lastTime;
        this.lastIp = lastIp;
        this.bgroup = bgroup;
        this.bid = bid;
        this.money = money;
        this.mobile = mobile;
        this.pwd = pwd;
        this.mail = mail;
        this.card = card;
        this.name = name;
        this.device = device;
        this.account = account;
        this.tourist = tourist;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInv() {
        return inv;
    }

    public void setInv(Integer inv) {
        this.inv = inv;
    }

    public String getInvGame() {
        return invGame;
    }

    public void setInvGame(String invGame) {
        this.invGame = invGame;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Integer getBgroup() {
        return bgroup;
    }

    public void setBgroup(Integer bgroup) {
        this.bgroup = bgroup;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getTourist() {
        return tourist;
    }

    public void setTourist(Integer tourist) {
        this.tourist = tourist;
    }

    public MemberQo() {

    }
}
