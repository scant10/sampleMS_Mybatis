package com.sk.sampleMS.domain.sample.model;

import java.io.*;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private String id;
    private String userName;
    private String passWord;
    
}
