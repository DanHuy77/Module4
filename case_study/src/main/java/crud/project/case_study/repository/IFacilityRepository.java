package crud.project.case_study.repository;

import crud.project.case_study.model.Facility;
import crud.project.case_study.model.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable);

    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
