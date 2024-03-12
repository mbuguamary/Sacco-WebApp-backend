package com.sacco.saccoapp.otp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pb_sacco_passkey")
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="mem_no")
    private String memNo;
    @Column(name="pass_key",insertable = false, updatable = false)
    private Integer passKey;
    @Column(insertable = false, updatable = false)
    private Date cdate;
    @Column(name="logged_in",insertable = false)
    private Boolean loggedIn;
    @Column(name="key_used",insertable = false)
    private Boolean keyUsed;

}
