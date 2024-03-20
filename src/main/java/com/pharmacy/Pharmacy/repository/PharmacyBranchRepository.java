package com.pharmacy.Pharmacy.repository;

import com.pharmacy.Pharmacy.model.PharmacyBranch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyBranchRepository extends JpaRepository<PharmacyBranch, Long> {
    @EntityGraph("PharmacyBranch.withRelations")
    List<PharmacyBranch> findAllByPharmacyBranchAddress_CountryIn(List<String> countries);

    @Override
    @EntityGraph("PharmacyBranch.withRelations")
    List<PharmacyBranch> findAll();
}
