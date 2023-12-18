package com.valtech.poc.lifecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.poc.lifecare.entity.MedicineDetails;

@Repository
public interface MedicineRepo extends JpaRepository<MedicineDetails, Integer> {

//	@Query("SELECT m FROM MedicineDetails m WHERE LOWER(m.medicineName) LIKE LOWER(CONCAT('%',:searchTerm,'%'))")
//	List<MedicineDetails> searchMedicine(@Param("searchTerm") String searchTerm);

	List<MedicineDetails> findByMedicineNameContaining(String searchTerm);

}
