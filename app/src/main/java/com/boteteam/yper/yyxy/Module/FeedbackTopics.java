package com.boteteam.yper.yyxy.Module;

/**
 * Created by Feng Jiang on 2018/2/6.
 */

public class FeedbackTopics {
private int idFeedbackTopics;
private String FeedbackTopicno;
private String FeedbackTopicanswer;
private int Feedback_idFeedback;

    public int getIdFeedbackTopics() {
        return idFeedbackTopics;
    }

    public void setIdFeedbackTopics(int idFeedbackTopics) {
        this.idFeedbackTopics = idFeedbackTopics;
    }

    public String getFeedbackTopicno() {
        return FeedbackTopicno;
    }

    public void setFeedbackTopicno(String feedbackTopicno) {
        FeedbackTopicno = feedbackTopicno;
    }

    public String getFeedbackTopicanswer() {
        return FeedbackTopicanswer;
    }

    public void setFeedbackTopicanswer(String feedbackTopicanswer) {
        FeedbackTopicanswer = feedbackTopicanswer;
    }

    public int getFeedback_idFeedback() {
        return Feedback_idFeedback;
    }

    public void setFeedback_idFeedback(int feedback_idFeedback) {
        Feedback_idFeedback = feedback_idFeedback;
    }
}
