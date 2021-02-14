package com.arisoft.addressbook.repository;

import com.arisoft.addressbook.model.AddressBook;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aritra Sengupta
 * on 2021-02-03.
 */

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}
