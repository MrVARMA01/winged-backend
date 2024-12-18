package com.winged.backend.services;
import com.winged.backend.entities.paintingAndRenovations.Paint;
import java.util.List;

public interface PaintService {
    String addPaint(Paint paint);
    List<Paint> allPaints();
    Paint paint(long id);
}
