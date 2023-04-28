package com.auth.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorizationController {

    @Operation(description = "Check user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check user successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server Error")
    })
    @GetMapping("/check")
    public ResponseEntity<?> checkAuthorization() {
        return ResponseEntity.ok().build();
    }
}
