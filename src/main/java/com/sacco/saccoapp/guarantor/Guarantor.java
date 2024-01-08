package com.sacco.saccoapp.guarantor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="guarators")
public class Guarantor {
    @Id
    private Long id;
    private String loan_no;
    private String member_name;
    private String  cdate;
    private String  lamount;
    private String lpurpose;
    private Double amtg;

    private String gtype;

    private String mem_no;


}
