package com.winged.backend.services;

import com.winged.backend.entities.ServiceField;

import java.util.List;

public interface ServiceFieldService {

    String saveServiceField (ServiceField service);
    List<ServiceField> allServiceFields();

    ServiceField fieldById(int id);

}
