package ru.mysak.rest.testcashbackrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mysak.rest.testcashbackrest.entity.Bill;
import ru.mysak.rest.testcashbackrest.facade.PaymentFacadeImpl;
import ru.mysak.rest.testcashbackrest.service.BillServiceImpl;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BillController {

    private final BillServiceImpl billService;
    private final PaymentFacadeImpl paymentFacade;

    @GetMapping("/{client_id}/money")
    public double clientDeposit(@PathVariable Long client_id) {
        return billService.readByClientId(client_id).getDeposit();
    }

    @GetMapping("/{client_id}/bankAccountOfEMoney")
    public double clientCashback(@PathVariable Long client_id) {
        return billService.readByClientId(client_id).getCashback();
    }

    @GetMapping("/payment/{client_id}/{payment_type}/{amount}")
    public boolean doPayment(@PathVariable Long client_id,
                             @PathVariable String payment_type,
                             @PathVariable int amount) {
        if (payment_type.equalsIgnoreCase("online")) {
            boolean result = paymentFacade.onlinePayment(client_id, amount);
            return result;
        } else if (payment_type.equalsIgnoreCase("shop")) {
            boolean result = paymentFacade.offlineShopPayment(client_id, amount);
            return result;
        }

        return false;
    }

}
