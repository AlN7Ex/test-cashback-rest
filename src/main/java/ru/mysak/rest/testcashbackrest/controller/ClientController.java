package ru.mysak.rest.testcashbackrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.facade.PaymentFacadeImpl;
import ru.mysak.rest.testcashbackrest.service.ClientServiceImpl;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;
    private final PaymentFacadeImpl paymentFacade;

    @GetMapping("/payment/{client_id}/{payment_type}/{amount}")
    public boolean doPayment(@PathVariable Long client_id,
                            @PathVariable String payment_type,
                            @PathVariable int amount) {
        if (payment_type.equalsIgnoreCase("online")) {
            boolean result = paymentFacade.onlinePayment(client_id, amount);
            return result;
        }
        else if (payment_type.equalsIgnoreCase("shop")) {
            boolean result = paymentFacade.offlineShopPayment(client_id, amount);
            return result;
        }

        return false;
    }
//    @GetMapping("/{client_id}/money")
//    public double clientDeposit(@PathVariable Long client_id) {
//    }
}
