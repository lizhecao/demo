package com.test.demo.mybatis.generator.model;

import java.util.Date;

public class TMsAppPluginMatch {
    private Integer id;

    private Integer appId;

    private Long mainId;

    private String mainVersion;

    private String appEnterprise;

    private String appType;

    private String appModel;

    private Integer pluginVersion;

    private String pluginId;

    private Byte del;

    private Integer cuid;

    private Integer muid;

    private Date cdate;

    private Date mdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    public String getMainVersion() {
        return mainVersion;
    }

    public void setMainVersion(String mainVersion) {
        this.mainVersion = mainVersion == null ? null : mainVersion.trim();
    }

    public String getAppEnterprise() {
        return appEnterprise;
    }

    public void setAppEnterprise(String appEnterprise) {
        this.appEnterprise = appEnterprise == null ? null : appEnterprise.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getAppModel() {
        return appModel;
    }

    public void setAppModel(String appModel) {
        this.appModel = appModel == null ? null : appModel.trim();
    }

    public Integer getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(Integer pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId == null ? null : pluginId.trim();
    }

    public Byte getDel() {
        return del;
    }

    public void setDel(Byte del) {
        this.del = del;
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Integer getMuid() {
        return muid;
    }

    public void setMuid(Integer muid) {
        this.muid = muid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }
}