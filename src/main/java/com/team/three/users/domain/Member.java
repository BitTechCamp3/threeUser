package com.team.three.users.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "member")
public class Member {

    @Id
    @Column
    private int index;

    @Column
    private String userid;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String role;

    @Column
    private Boolean useyn;

    @Column
    private Timestamp createdt;

}
