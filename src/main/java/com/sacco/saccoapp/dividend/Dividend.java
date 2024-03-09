package com.sacco.saccoapp.dividend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ac_dividend_qnr")
public class Dividend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="acc_name")
    private String accName;
    @Column(name="acc_no")
    private String accNo;
    private String description;
    @Column(name="user_name")
    private String userName;
    @Column(name="pmode")
    private String pMode;
    private Date date;
    private Boolean processed;
    @Column(name="input_date")
    private Date inputDate;
    private Double amount;

    @PrePersist
    public void init(){
        this.userName = SecurityContextHolder.getContext().getAuthentication().getName();
        this.date = new Date();
        this.inputDate = new Date();
    }
}
