package com.company.NationalPen.service;

import com.company.NationalPen.entity.MaterialEntity;
import com.company.NationalPen.exelfile.WorkBookExel;
import com.company.NationalPen.repository.PenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbNPService {

    @Autowired
    private PenRepository penRepository;

    @Autowired
    private WorkBookExel workBookExel;

    public void addMaterial(MaterialEntity materialEntity) {
        penRepository.save(materialEntity);
        workBookExel.createFile(materialEntity);
    }

    public List<MaterialEntity> viewMaterial() {
        return penRepository.findAll();
    }

    public String deleteById(Integer id, String url) {
        penRepository.deleteById(id.longValue());
        return url;
    }

    public String deleteAll(String url) {
        penRepository.deleteAll();
        return url;
    }
}
