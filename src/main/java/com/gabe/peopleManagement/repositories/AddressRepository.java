package com.gabe.peopleManagement.repositories;

import com.gabe.peopleManagement.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, Long> {

  List<Address> findAllByOwner_Id(UUID uuid);

  Address findFirstByOwner_IdAndIsPrimaryIsTrue(UUID uuid);

}
