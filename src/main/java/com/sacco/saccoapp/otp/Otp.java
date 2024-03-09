package com.sacco.saccoapp.otp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pb_password_key")
public class Otp {

    private Integer id;
    @Column(name="mem_no")
    private String memNo;
    @Column(name="pass_key")
    private Integer passKey;

}
