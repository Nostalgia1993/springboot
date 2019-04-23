package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2680596030939628347L;

    private long id;
    private Date created;
    private Date modified;
    private int status;

}
