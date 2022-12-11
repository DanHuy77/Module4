package crud.project.case_study.repository;

import crud.project.case_study.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
