package crud.project.case_study.service.impl;

import crud.project.case_study.model.AttachedService;
import crud.project.case_study.repository.IAttachedServiceRepository;
import crud.project.case_study.service.IAttachedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AttachedServiceService implements IAttachedServiceService {

    @Autowired
    private IAttachedServiceRepository attachedServiceRepository;

    @Override
    public Page<AttachedService> findAll(Pageable pageable) {
        return attachedServiceRepository.findAll(pageable);
    }

    @Override
    public AttachedService findById(Integer id) {
        return attachedServiceRepository.findById(id).get();
    }

    @Override
    public void save(AttachedService attachedService) {
        attachedServiceRepository.save(attachedService);
    }

    @Override
    public void remove(Integer id) {
        attachedServiceRepository.deleteById(id);
    }
}
