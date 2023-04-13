package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.CategoryException;
import com.nocountryproject.Backend.mapper.QualificationInDTOToQualification;
import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.persistence.entity.Qualification;
import com.nocountryproject.Backend.persistence.repository.QualificationRepository;
import com.nocountryproject.Backend.service.dto.CategoryInDTO;
import com.nocountryproject.Backend.service.dto.QualificationInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService {

    private final QualificationRepository repository;
    private final QualificationInDTOToQualification mapper;

    public QualificationService(QualificationRepository repository, QualificationInDTOToQualification mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Qualification createQualification(QualificationInDTO qualificationInDTO){
        Qualification qualification = mapper.map(qualificationInDTO);
        return this.repository.save(qualification);
    }

    public void deleteById(Long id){
        Optional<Qualification> optionalQualification= this.repository.findById(id);

        if(optionalQualification.isEmpty()){
            throw new CategoryException("Qualification not found.", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

    public List<Qualification> findAll(){
        return this.repository.findAll();
    }


}
