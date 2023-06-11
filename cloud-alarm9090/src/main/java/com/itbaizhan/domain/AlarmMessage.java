package com.itbaizhan.domain;

import lombok.Data;

import java.util.List;

@Data
public class AlarmMessage {

    private int scopeId;
    private String scope;
    private String name;
    private String id0;
    private String id1;
    // 规则名字
    private String ruleName;
    // 告警信息
    private String alarmMessage;
    private List<Tag> tags;
    // 时间
    private long startTime;
    private transient int period;
    private transient boolean onlyAsCondition;
    @Data
    public static class Tag{
        private String key;
        private String value;
    }
}
