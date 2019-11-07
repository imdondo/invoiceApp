package tech.ioco.digitalplatoon.invoiceapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;

}
