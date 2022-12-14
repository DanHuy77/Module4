package crud.project.case_study.service;

import crud.project.case_study.dto.AttachedServiceDto;
import crud.project.case_study.model.AttachedService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachedServiceService extends IGeneralService<AttachedService> {
    List<AttachedServiceDto> getAttachServiceList(@Param("id") Integer id);
}
