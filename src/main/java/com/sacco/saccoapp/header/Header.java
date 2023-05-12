package com.sacco.saccoapp.header;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pb_header")
public class Header {
   @Id
   @GeneratedValue
    private String header_name;
    private Date date;
    private String company_logo;

}
