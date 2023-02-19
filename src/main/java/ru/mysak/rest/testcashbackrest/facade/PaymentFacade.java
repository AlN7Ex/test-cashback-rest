package ru.mysak.rest.testcashbackrest.facade;

import org.springframework.stereotype.Service;

@Service
public interface PaymentFacade {

    boolean onlinePayment(Long client_id, int price);
    boolean offlineShopPayment(Long client_id, int price);

}
