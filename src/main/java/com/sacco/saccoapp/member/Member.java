package com.sacco.saccoapp.member;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String acc_no;
    private String holders_name;
    private String postal_address;
    private String id_no;
    private String email_add;
    private String tel1;
}
