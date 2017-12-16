package purple.mnt.model;

import java.time.LocalDateTime;

public class MssHealth {
    public String ID ;
    public String STATUS ;
    public LocalDateTime CREATE_TIME ;
    public String CREATOR_ID ;
    public LocalDateTime MODIFY_TIME ;
    public String MODIFIER_ID;
    public String APP_NAME ;
    public String REMARK ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public LocalDateTime getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(LocalDateTime CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getCREATOR_ID() {
        return CREATOR_ID;
    }

    public void setCREATOR_ID(String CREATOR_ID) {
        this.CREATOR_ID = CREATOR_ID;
    }

    public LocalDateTime getMODIFY_TIME() {
        return MODIFY_TIME;
    }

    public void setMODIFY_TIME(LocalDateTime MODIFY_TIME) {
        this.MODIFY_TIME = MODIFY_TIME;
    }

    public String getMODIFIER_ID() {
        return MODIFIER_ID;
    }

    public void setMODIFIER_ID(String MODIFIER_ID) {
        this.MODIFIER_ID = MODIFIER_ID;
    }

    public String getAPP_NAME() {
        return APP_NAME;
    }

    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }






}
