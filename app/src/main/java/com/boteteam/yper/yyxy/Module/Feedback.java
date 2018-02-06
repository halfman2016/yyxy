package com.boteteam.yper.yyxy.Module;

import java.sql.Date;

/**
 * Created by Feng Jiang on 2018/2/6.
 */

public class Feedback {
    private int idFeedback;
    private String Feedbackteaname;
    private String Feedbackteaid;
    private Date Feedbacklastime;
    private String Feedbackstuname;
    private String Feedbackstuid;

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getFeedbackteaname() {
        return Feedbackteaname;
    }

    public void setFeedbackteaname(String feedbackteaname) {
        Feedbackteaname = feedbackteaname;
    }

    public String getFeedbackteaid() {
        return Feedbackteaid;
    }

    public void setFeedbackteaid(String feedbackteaid) {
        Feedbackteaid = feedbackteaid;
    }

    public Date getFeedbacklastime() {
        return Feedbacklastime;
    }

    public void setFeedbacklastime(Date feedbacklastime) {
        Feedbacklastime = feedbacklastime;
    }

    public String getFeedbackstuname() {
        return Feedbackstuname;
    }

    public void setFeedbackstuname(String feedbackstuname) {
        Feedbackstuname = feedbackstuname;
    }

    public String getFeedbackstuid() {
        return Feedbackstuid;
    }

    public void setFeedbackstuid(String feedbackstuid) {
        Feedbackstuid = feedbackstuid;
    }
}
