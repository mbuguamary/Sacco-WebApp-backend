package com.sacco.saccoapp.instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pb_saccoloan")
public class Instant {
    @Id
    @GeneratedValue
    private Long id;
    private String mem_no;
    private String member_name;
    private String loan_no;
    private String pno;
    private String wstation;
    private String employer;
    private String postal_code;
    private String categ;
    private String email_address;
    private String security1;
    private String id_no;
    private String lpurpose;
    private String pymt_terms;
    private Date cdate = new Date();
    private Date edate;
    private Double amount;
    private Double period;
    private Double repayment;
    private Double interest;
    private Double premium;
    private String user_name;
    private Date input_date;

    @PrePersist
    public void init(){
        this.user_name = SecurityContextHolder.getContext().getAuthentication().getName();
        this.cdate = new Date();
        this.input_date = new Date();
    }
}
