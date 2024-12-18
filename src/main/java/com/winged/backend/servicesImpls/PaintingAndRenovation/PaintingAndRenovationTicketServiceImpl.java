package com.winged.backend.servicesImpls.PaintingAndRenovation;
import com.winged.backend.entities.ActualService;
import com.winged.backend.entities.Booking;
import com.winged.backend.entities.User;
import com.winged.backend.entities.paintingAndRenovations.PaintingAndRenovationTicket;
import com.winged.backend.repositories.BookingRepository;
import com.winged.backend.repositories.PaintingAndRenovation.PaintingAndRenovationTicketRepository;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.ActualServiceService;
import com.winged.backend.services.PaintingAndRenovation.PaintingAndRenovationTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PaintingAndRenovationTicketServiceImpl implements PaintingAndRenovationTicketService {
    @Autowired
    private PaintingAndRenovationTicketRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActualServiceService actualService;
    @Autowired
    private BookingRepository bookingRepository;

    public String validateTicket(PaintingAndRenovationTicket ticket) throws NullPointerException {
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
            } else if (ticket.getBookingDate().equals("") || ticket.getBookingDate().equals(null)) {
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
    public String addNewTicket(PaintingAndRenovationTicket ticket) {
        try{
            String isValid = validateTicket(ticket);
            if (isValid.equals("Booking validated"))
            {
                Booking booking = bookingRepository.findById(ticket.getId());
                booking.setDeleted(true);
                booking.setStatus("Approved");
                bookingRepository.save(booking);
                int area = (int) ticket.getAreaInSqft();
                ActualService actService = actualService.actualServiceById(ticket.getActualService());
                ticket.setPricePerSqft(actService.getServiceDetails().getPrice());
                ticket.setServicePrice(area * actService.getServiceDetails().getPrice());
                ticket.setConsultationFee(249.00 );
                ticket.setCommitmentDays(1);
                ticket.setTotalPrice(ticket.getServicePrice());
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

    @Override
    public List<PaintingAndRenovationTicket> allTickets() {
        return repository.findAll();
    }

    @Override
    public List<PaintingAndRenovationTicket> allUserTickets(long userId) {
        if (userId != 0){
            return repository.findByUserId(userId);
        }else {
            return null;
        }
    }

    @Override
    public String updateStatus(long tid, String status) {
        if (tid!=0){
            PaintingAndRenovationTicket TData = repository.findById(tid);
            TData.setStatus(status);
            repository.save(TData);
            return "Record Saved";
        }
        else {
            return "Ticket Not Found!";
        }
    }

    @Override
    public void createTransaction(double amount) {
    }
}
