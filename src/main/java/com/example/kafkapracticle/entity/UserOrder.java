package com.example.kafkapracticle.entity;


public class UserOrder {
    String companyId, siteId, userId, status;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "companyId='" + companyId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
