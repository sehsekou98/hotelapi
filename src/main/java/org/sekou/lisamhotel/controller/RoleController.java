package org.sekou.lisamhotel.controller;


import lombok.RequiredArgsConstructor;
import org.sekou.lisamhotel.service.IBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final IBookingService iBookingService;

    @GetMapping("/all-role")
    public ResponseEntity<List<Role>>
}
