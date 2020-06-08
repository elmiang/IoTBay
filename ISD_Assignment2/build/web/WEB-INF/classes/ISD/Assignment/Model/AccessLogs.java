/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model;

/**
 *
 * @author CristinaFidelino
 */
public class AccessLogs {
    
    private int visitId;
    private int userId;
    private String loginTime;
    private String logoutTime;

    public AccessLogs(int visitId, int userId, String loginTime, String logoutTime) {
        this.visitId = visitId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    
    
}
