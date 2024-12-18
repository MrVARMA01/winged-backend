package com.winged.backend.servicesImpls;
import com.winged.backend.entities.paintingAndRenovations.Paint;
import com.winged.backend.repositories.PaintRepository;
import com.winged.backend.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PaintServiceImpl implements PaintService {
    @Autowired
    private PaintRepository repository;
    @Override
    public String addPaint(Paint paint) {
        if (paint == null){
            return "Record Failed!";
        }
        else{
            repository.save(paint);
            return "Record Saved!";
        }
    }

    @Override
    public List<Paint> allPaints() {
        return repository.findAll();
    }

    @Override
    public Paint paint(long id) {
        return repository.findById(id);
    }
}
