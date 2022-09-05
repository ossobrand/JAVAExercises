package spring.springboot.WebBackend.Trip.infraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;

import java.util.Date;

@RestController
@RequestMapping("api/v0")
public class TripController {

    @GetMapping("/availability/:destinationCity")
    public TicketOutputDTO getAvailabilityRoute(
            @RequestParam Date inferiorDate,
            @RequestParam(required = false) Date superiorDate,
            @RequestParam(required = false) Date inferiorHour,
            @RequestParam(required = false) Date superiorHour

    ){
        return null;
    }
}
