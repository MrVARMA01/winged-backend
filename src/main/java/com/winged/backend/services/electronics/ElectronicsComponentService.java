package com.winged.backend.services.electronics;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import java.util.List;

public interface ElectronicsComponentService {
    String addComponentAndPrice(ElectronicsComponent componentAndPrice);
    List<ElectronicsComponent> allComponentsAndPrices();
    ElectronicsComponent ComponentAndPrice(long id);
}
