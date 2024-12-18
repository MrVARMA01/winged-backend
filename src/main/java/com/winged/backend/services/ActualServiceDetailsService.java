package com.winged.backend.services;

import com.winged.backend.entities.ActualServiceDetails;

import java.util.List;

public interface ActualServiceDetailsService {
    String addActualServiceDetails(ActualServiceDetails details);
    ActualServiceDetails actualServiceDetails(long id);
    List<ActualServiceDetails> allActualServiceDetails();
}
