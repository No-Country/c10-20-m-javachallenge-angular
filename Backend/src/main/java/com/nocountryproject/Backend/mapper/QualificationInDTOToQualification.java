package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Qualification;
import com.nocountryproject.Backend.service.dto.QualificationInDTO;
import org.springframework.stereotype.Component;

@Component
public class QualificationInDTOToQualification implements IMapper<QualificationInDTO, Qualification>{

    public Qualification map(QualificationInDTO in){
        Qualification qualification = new Qualification();
        qualification.setIdUser(in.getIdUser());
        qualification.setIdBook(in.getIdBook());
        qualification.setScore(in.getScore());
        qualification.setReview(in.getReview());
        return qualification;

    }

}
