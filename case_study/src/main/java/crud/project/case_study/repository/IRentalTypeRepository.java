package crud.project.case_study.repository;

import crud.project.case_study.model.RentalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalTypeRepository extends JpaRepository<RentalType, Integer> {
}
