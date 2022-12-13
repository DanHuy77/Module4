package crud.project.case_study.repository;

import crud.project.case_study.model.AttachedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachedServiceRepository extends JpaRepository<AttachedService, Integer> {
//    AttachedService findAttachedServiceBy
}
