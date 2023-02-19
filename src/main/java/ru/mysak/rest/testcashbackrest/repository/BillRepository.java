package ru.mysak.rest.testcashbackrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.rest.testcashbackrest.entity.Bill;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findBillById(Long id);
    Bill findBillByClientId(Long client_id);
    List<Bill> findAll();
    boolean deleteBillById(Long id);
}
