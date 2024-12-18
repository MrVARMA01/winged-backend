package com.winged.backend.services.electronics;
import com.winged.backend.entities.electronics.ElectronicsTicket;
import java.util.List;

public interface ElectronicsTicketService {
    String newTicket(ElectronicsTicket ticket);

//    String bookingProcessing(long id);
//    String bookingCompleted(long id);
    String updateTicket(ElectronicsTicket ticket);
    List<ElectronicsTicket> allElectronicsTickets();
    List<ElectronicsTicket> allUserTickets(long userId);
    ElectronicsTicket ticket(long id);
    String deleteTicket(long id);
}
