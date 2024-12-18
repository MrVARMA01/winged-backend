package com.winged.backend.services;

import com.winged.backend.entities.SubField;

import java.util.List;

public interface SubFieldService {
    String addSubService(SubField service);
    List<SubField> allSubServices();
    SubField subServiceById(long id);
    List<SubField> subServicesByFieldId(int id);

}
