package tech.ioco.digitalplatoon.invoiceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;
import tech.ioco.digitalplatoon.invoiceapp.repository.InvoiceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        List<Invoice> invoices = new ArrayList<>();

        invoiceRepository.findAll().forEach(invoice -> {
            invoices.add(new Invoice(invoice.getId(), invoice.getClient(), invoice.getVatRate(), invoice.getInvoiceDate()));
        });

        if (invoices.size() > 0) {
            return invoices;
        } else {
            throw new EntityNotFoundException("No Invoices Found in the Database");
        }
    }

    @Override
    public Invoice findById(long id) {
        if (invoiceRepository.findById(id).isPresent()) {
            Invoice fetchedInvoice = invoiceRepository.findById(id).get();
            return new Invoice(fetchedInvoice.getId(), fetchedInvoice.getClient(), fetchedInvoice.getVatRate(), fetchedInvoice.getInvoiceDate());
        } else {
            throw new EntityNotFoundException("Invoice Id " + id + " not found in the database");
        }
    }

    @Override
    public Invoice save(Invoice invoice) {
        Invoice newInvoice = new Invoice();
        newInvoice.setClient(invoice.getClient());
        newInvoice.setVatRate(invoice.getVatRate());
        newInvoice.setInvoiceDate(invoice.getInvoiceDate());
        return invoiceRepository.save(newInvoice);
    }
}
