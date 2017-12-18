package purple.mnt.model;

import java.time.LocalDateTime;

public class MssAppMonitor {
    private String id;
    private String app_id;
    private LocalDateTime create_time;
    private String creator_id;
    private LocalDateTime modify_time;
    private String modifier_id;
    private String app_name;
    private String status;
    private String remark;
    private String mnt_name;
    private String mnt_nul;
    private String mnt_status;
    private String mnt_mobile;
    private Double time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public LocalDateTime getModify_time() {
        return modify_time;
    }

    public void setModify_time(LocalDateTime modify_time) {
        this.modify_time = modify_time;
    }

    public String getModifier_id() {
        return modifier_id;
    }

    public void setModifier_id(String modifier_id) {
        this.modifier_id = modifier_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMnt_name() {
        return mnt_name;
    }

    public void setMnt_name(String mnt_name) {
        this.mnt_name = mnt_name;
    }

    public String getMnt_nul() {
        return mnt_nul;
    }

    public void setMnt_nul(String mnt_nul) {
        this.mnt_nul = mnt_nul;
    }

    public String getMnt_status() {
        return mnt_status;
    }

    public void setMnt_status(String mnt_status) {
        this.mnt_status = mnt_status;
    }

    public String getMnt_mobile() {
        return mnt_mobile;
    }

    public void setMnt_mobile(String mnt_mobile) {
        this.mnt_mobile = mnt_mobile;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }


}
