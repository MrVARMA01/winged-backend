package com.winged.backend.services.electronics;

import com.winged.backend.entities.electronics.ElectronicDeviceModel;

import java.util.List;

public interface ElectronicDeviceModelService {
    String addModel(ElectronicDeviceModel model);
    List<ElectronicDeviceModel> allModels();
    List<ElectronicDeviceModel> allModelsByBrand(long id);
    ElectronicDeviceModel model(long id);
}
