package com.sacco.saccoapp.member;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pb_share_register")
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="acc_no")
    private String accNo;
    @Column(name="holders_name")
    private String holdersName;
    @Column(name="postal_address")
    private String postalAddress;
    @Column(name="id_no")
    private String idNo;
    @Column(name="email_add")
    private String emailAdd;
    private String tel1;
}
