package com.example.demo.repository;

import com.example.demo.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Integer> {

    @Query(value = "SELECT * FROM adres LIMIT 2 OFFSET :skipRows",nativeQuery = true)
    public List<Adres> getAdresWithPagination(@Param(value = "skipRows") int skipRows);
}
