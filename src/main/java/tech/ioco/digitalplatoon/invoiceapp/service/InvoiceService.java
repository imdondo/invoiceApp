package tech.ioco.digitalplatoon.invoiceapp.service;

import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice findById(long id);

    Invoice save(Invoice invoice);
}
