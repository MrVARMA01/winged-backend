package com.winged.backend.services;

import com.winged.backend.entities.ActualService;

import java.util.List;

public interface ActualServiceService {
    String addActualService(ActualService service);
    List<ActualService> allActualServices();
    ActualService actualServiceById(long id);
    List<ActualService> actualServicesBySubService(long id);
}
