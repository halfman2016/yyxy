package com.boteteam.yper.yyxy.SchoolModule;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Feng Jiang on 2017/9/30.
 */

public class Timu {
    private UUID _id=UUID.randomUUID();
    private String timutxt; //题目文本
    private int timuno; //题号
    private String answer; //题目答案 ，保留字段

    public UUID get_id() {
        return _id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTimutxt() {
        return timutxt;
    }

    public void setTimutxt(String timutxt) {
        this.timutxt = timutxt;
    }

    public int getTimuno() {
        return timuno;
    }

    public void setTimuno(int timuno) {
        this.timuno = timuno;
    }
}
