package ru.mysak.rest.testcashbackrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Bill;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.repository.BillRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    @Override
    public Bill read(Long id) {
        return null;
    }

    @Override
    public Bill readByClientId(Long client_id) {
        return billRepository.findBillByClientId(client_id);
    }

    @Override
    public List<Bill> readAll() {
        return null;
    }

    @Override
    public boolean create(Bill bill) {
        return false;
    }

    @Override
    public boolean update(Bill bill) {
        billRepository.save(bill);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
