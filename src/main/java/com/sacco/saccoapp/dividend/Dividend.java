package com.sacco.saccoapp.dividend;

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
@Table(name="pb_dividend_qnr")
public class Dividend {
    @Id
    @GeneratedValue
    private Long id;
    private String acc_name;
    private String acc_no;
    private String user_name;
    private String pmode;
    private Double amount;

    public Dividend(String acc_name, String acc_no, String user_name, String pmode, Double amount) {
        this.acc_name = acc_name;
        this.acc_no = acc_no;
        this.user_name = user_name;
        this.pmode = pmode;
        this.amount = amount;
    }
}
