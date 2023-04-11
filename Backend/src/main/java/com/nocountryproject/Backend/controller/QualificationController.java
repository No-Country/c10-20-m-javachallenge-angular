package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Qualification;
import com.nocountryproject.Backend.service.QualificationService;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import com.nocountryproject.Backend.service.dto.QualificationInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

    private final QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping
    public Qualification createQualification(@RequestBody QualificationInDTO qualificationInDTO){
        return this.qualificationService.createQualification(qualificationInDTO);
    }

    @GetMapping
    public List<Qualification> findAllQualification(){
        return this.qualificationService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.qualificationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
