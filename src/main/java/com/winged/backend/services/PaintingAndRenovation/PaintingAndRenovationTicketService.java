package com.winged.backend.services.PaintingAndRenovation;
import com.winged.backend.entities.paintingAndRenovations.PaintingAndRenovationTicket;
import java.util.List;

public interface PaintingAndRenovationTicketService {
    String addNewTicket(PaintingAndRenovationTicket ticket);
    List<PaintingAndRenovationTicket> allTickets();
    List<PaintingAndRenovationTicket> allUserTickets(long userId);
    String updateStatus(long Tid, String status);
    void createTransaction(double amount);

}
