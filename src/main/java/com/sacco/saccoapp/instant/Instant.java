package com.sacco.saccoapp.instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pb_saccoloan")
public class Instant {
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
    private Date cdate;
    private Date edate;
    private Double amount;
    private Double period;
    private Double repayment;
    private Double interest;
    private Double premium;
    private String user_name;
    private Date input_date;
}
