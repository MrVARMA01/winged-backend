package com.winged.backend.servicesImpls.electronics;
import com.winged.backend.entities.Booking;
import com.winged.backend.entities.electronics.ElectronicsCompQualityType;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import com.winged.backend.entities.electronics.ElectronicsTicket;
import com.winged.backend.entities.User;
import com.winged.backend.repositories.BookingRepository;
import com.winged.backend.repositories.electronics.ElectronicsCompQualityTypeRepository;
import com.winged.backend.repositories.electronics.ElectronicsTicketRepository;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.electronics.ElectronicsCompQualityTypeService;
import com.winged.backend.services.electronics.ElectronicsComponentService;
import com.winged.backend.services.electronics.ElectronicsTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ElectronicsTicketServiceImpl implements ElectronicsTicketService {
    @Autowired
    private ElectronicsTicketRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ElectronicsCompQualityTypeRepository typeRepository;
    @Autowired
    private ElectronicsCompQualityTypeService componentTypeService;
    @Autowired
    private BookingRepository bookingRepository;

    private ElectronicsCompQualityType componentType;

    public String validateTicket(ElectronicsTicket ticket) throws NullPointerException {
        User user = userRepository.findByUserId(ticket.getUserId());
        if (user == null){
            return "USER DOES NOT EXIST !";
        }
        else {
            if (ticket.getCustomerName().equals("") || ticket.getCustomerName().equals(null)) {
                return "Enter proper name";
            } else if (ticket.getEmail().equals("") || ticket.getEmail().equals(null)) {
                return "Enter proper email";
            } else if (ticket.getPhone() == 0 || ticket.getPhone() == 91) {
                return "Enter proper phone";
            } else if (ticket.getAddress().equals("") || ticket.getAddress().equals(null)) {
                return "Enter proper address";
            } else if (ticket.getServiceField() == 0) {
                return "Invalid Service-Field";
            }else if (ticket.getSubField() == 0) {
                return "Invalid Sub-Field";
            } else if (ticket.getActualService() == 0) {
                return "Invalid Actual-service";
            } else if (ticket.getIssueDescription().equals("") || ticket.getIssueDescription().equals(null)) {
                return "Enter proper description";
            }else if (ticket.getBrand() == 0) {
                return "Invalid Brand";
            } else if (ticket.getModel() == 0) {
                return "Invalid Model";
            } else if (ticket.getComponent()==0) {
                return "Invalid Component";
            } else if (ticket.getBookingDate().equals("") || ticket.getIssueDescription().equals(null)) {
                return "Invalid Booking Date";
            }  else {
                String str = Long.toString(ticket.getPhone());
                Pattern phonePtrn = Pattern.compile("(0/91)?[6-9][0-9]{11}");
                Matcher match = phonePtrn.matcher(str);
                boolean isValid1 = match.find() && match.group().equals(str);

                Pattern emailPtrn = Pattern.compile("^(.+)@(.+)$");
                match = emailPtrn.matcher(ticket.getEmail());
                boolean isValid2 = match.find() && match.group().equals(ticket.getEmail());

                if (isValid1 != true || isValid2 != true) {
                    System.out.println("\n-Invalid PhoneNumber or Email");
                    throw new NullPointerException();
                } else {
                    return "Booking validated";
                }
            }
        }
    }
    @Override
    public String newTicket(ElectronicsTicket ticket) {
        try{
            String isValid = validateTicket(ticket);
            if (isValid.equals("Booking validated"))
            {
                Booking booking = bookingRepository.findById(ticket.getId());
                booking.setDeleted(true);
                booking.setStatus("Approved");
                bookingRepository.save(booking);

                    componentType = componentTypeService.compQualityType(ticket.getComponentType());
                    ticket.setComponentPrice(componentType.getPrice());
                    ticket.setServicePrice(199);
                    ticket.setCommitmentDays(1);
                    ticket.setTotalPrice(ticket.getComponentPrice() + ticket.getServicePrice());
                    ticket.setApprovalDate(LocalDate.now());
                    ticket.setUpdatedDate(LocalDate.now());
                    ticket.setStatus("Approved");
                    ticket.setPaymentStatus("Pending");
                    ticket.setDeleted(false);
                    repository.save(ticket);
                    return "Ticket Activated!";
            }else {
                return isValid;
            }
        }catch (Exception e){
            System.out.println(e);
            return "Booking Failed!";
        }

    }


//    @Override
//    public String bookingProcessing(long id) {
//        if (id == 0){
//            return "Invalid Id!";
//        }else {
//            ElectronicsServiceBooking booking = repository.findById(id);
//            booking.setStatus("Processing");
//            repository.save(booking);
//            return "Service Under Processing";
//        }
//    }
//
//    @Override
//    public String bookingCompleted(long id) {
//        if (id == 0){
//            return "Invalid Id!";
//        }else {
//            ElectronicsServiceBooking booking = repository.findById(id);
//            booking.setStatus("Completed");
//            repository.save(booking);
//            return "Service Completed";
//        }
//    }

    @Override
    public String updateTicket(ElectronicsTicket booking) {
        return null;
    }

    @Override
    public List<ElectronicsTicket> allElectronicsTickets() {
        return repository.findAll();
    }

    @Override
    public List<ElectronicsTicket> allUserTickets(long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public ElectronicsTicket ticket(long id) {
        return repository.findById(id);
    }

    @Override
    public String deleteTicket(long id) {
        if (id == 0){
            return "Invalid Id!";
        }else {
            ElectronicsTicket ticket = repository.findById(id);
            ticket.setDeleted(true);
            repository.save(ticket);
            return "Deleted";
        }
    }
}
