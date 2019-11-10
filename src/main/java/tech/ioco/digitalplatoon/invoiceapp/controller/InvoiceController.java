package tech.ioco.digitalplatoon.invoiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ioco.digitalplatoon.invoiceapp.model.Invoice;
import tech.ioco.digitalplatoon.invoiceapp.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    //Creates a new invoice
    @PostMapping
    public Invoice addInvoice(@RequestBody final Invoice invoice) {
        invoiceService.save(invoice);
        return invoiceService.findById(invoice.getId());
    }

    //Fetches all invoices
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Invoice>> viewAllInvoices() {
        return new ResponseEntity<>(invoiceService.findAll(), HttpStatus.OK);
    }

    //Fetches invoice by id
    //    Take note for some reason this does not a parameter according to the spec
    @GetMapping(value = "/{invoiceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Invoice> viewInvoice(@PathVariable(value = "invoiceId") long invoiceId) throws Exception {
        return new ResponseEntity<>(invoiceService.findById(invoiceId), HttpStatus.OK);
    }
}
