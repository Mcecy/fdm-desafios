package com.mcecy.desafiocrudclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcecy.desafiocrudclientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
