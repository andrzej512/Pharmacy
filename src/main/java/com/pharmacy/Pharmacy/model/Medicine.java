package com.pharmacy.Pharmacy.model;

import com.pharmacy.Pharmacy.service.PharmacyService;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medicine_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "medicine_form")
    private MedicineForm medicineForm;

}
