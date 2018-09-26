package com.sk.sampleMS.domain.sample.model;

import java.sql.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoard{
    private String boardId;
    private String userName;
    private String title;
    private String category;
    private String content;
    private int viewCount;
    private Date wdate;
}
