package ar.edu.unnoba.primero.controller;

import ar.edu.unnoba.primero.DTO.RoomAvailabilityDTO;
import ar.edu.unnoba.primero.Modelo.Room;
import ar.edu.unnoba.primero.service.BookingService;
import ar.edu.unnoba.primero.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private RoomService roomService;
    private ModelMapper modelMapper;

    public BookingController(RoomService roomService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/availability")
    public String availability(Model model){
        model.addAttribute("roomsAvailability", new RoomAvailabilityDTO() );
        return "../templates.booking/availability";
    }

    @PostMapping("/booking")
    public String checkAvailability(@ModelAttribute RoomAvailabilityDTO roomAvailabilityDTO, Model model){
        List <Room> rooms = new ArrayList<>();
        try{
            rooms = roomService.getRoomsAvailable(
                    roomAvailabilityDTO.getCheckInDateConverted(),
                    roomAvailabilityDTO.getCheckOutDateConverted(),
                    roomAvailabilityDTO.getCapacity()

            );
        } catch (Exception e){}
    }
}
