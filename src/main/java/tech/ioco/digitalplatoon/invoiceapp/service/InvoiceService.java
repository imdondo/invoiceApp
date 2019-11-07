package tech.ioco.digitalplatoon.invoiceapp.service;

import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(long id);
    Invoice addInvoice(Invoice invoice);
}
