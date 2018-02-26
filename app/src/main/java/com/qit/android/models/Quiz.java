package com.qit.android.models;

import java.util.Date;

import lombok.Data;

@Data
public abstract class Quiz {

    private Long id;
    private String summary;
    private String description;
    private String password;
    private Date startDate;
    private Date endDate;
    private User user;
}