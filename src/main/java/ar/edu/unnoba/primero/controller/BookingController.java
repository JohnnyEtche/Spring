package ar.edu.unnoba.primero.controller;

import ar.edu.unnoba.primero.DTO.*;
import ar.edu.unnoba.primero.Modelo.Room;
import ar.edu.unnoba.primero.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private RoomService roomService;
    private ModelMapper modelMapper;

    @Autowired
    public BookingController(RoomService roomService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/availability")
    public String availability(Model model){
        model.addAttribute("roomsAvailability", new RoomAvailabilityDTO() );
        return "../templates.booking/availability";
    }

    @PostMapping("/availability")
    public String checkAvailability(@ModelAttribute RoomAvailabilityDTO roomAvailabilityDTO, Model model){
        List <Room> rooms = new ArrayList<>();
        try{
            rooms = roomService.getRoomsAvailable(
                    roomAvailabilityDTO.getCheckInDateConverted(),
                    roomAvailabilityDTO.getCheckOutDateConverted(),
                    roomAvailabilityDTO.getCapacity()

            );
        } catch (Exception e){}
        List<RoomDTO> roomsDTO = rooms.stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .collect(Collectors.toList());
        model.addAttribute("rooms", roomsDTO);
        model.addAttribute("roomsAvailability", roomAvailabilityDTO);
        model.addAttribute("booking", new NewBookingRequestDTO());
        return "../templates.booking/availability";
    }
    @PostMapping("/new")
    public String newBooking(@ModelAttribute NewBookingRequestDTO newBookingRequestDTO, Model model){
        NewBookingResponseDTO book = new NewBookingResponseDTO();
        RoomDTO roomDTO = modelMapper.map(roomService.findById(newBookingRequestDTO.getRoomId()).get(), RoomDTO.class);
        book.setRoom(roomDTO);
        book.setCheckIn(newBookingRequestDTO.getCheckIn());
        book.setCheckOut(newBookingRequestDTO.getCheckOut());
        book.setOccupancy(newBookingRequestDTO.getOccupancy());
        model.addAttribute("book",book);
        return "../templates.booking/new";
    }
    @PostMapping("/confirm")
    public String createBooking(@ModelAttribute ConfirmBookingRequestDTO confirmBookingRequestDTO){
        return "../templates.booking/availability";
    }
}

