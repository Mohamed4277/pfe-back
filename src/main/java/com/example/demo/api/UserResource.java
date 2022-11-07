package com.example.demo.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.domain.Adresses;
import com.example.demo.domain.PaymentMode;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.AdressesService;
import com.example.demo.service.PaymentModeService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;
    private final AdressesService adressesService;
    private final PaymentModeService paymentModeService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
       return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUser(@PathVariable("userName")  String userName){
        return ResponseEntity.ok().body(userService.findByUsername(userName));
    }

    @GetMapping("/user/user-by-id/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id")  Long id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUserRegister(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/user/{userName}/adress")
    public ResponseEntity<Adresses>  saveAdressUser(@PathVariable String userName , @RequestBody Adresses adress){
        Adresses adressSaved=adressesService.saveAdresses(adress);
        User user=userService.getUser(userName);
        user.getAdresses().add(adress);
        userService.saveUser(user);
        return ResponseEntity.ok().body(adressSaved);}

    @PutMapping("/user/{userName}/adress/{adressId}")
    public ResponseEntity<Adresses>  updateAdressUser(@PathVariable("userName") String userName ,
                                                      @PathVariable("adressId") Long id,
                                                      @RequestBody Adresses adress) {
        Optional<Adresses> adressFound = adressesService.findById(id);
        if (adressFound.isPresent()) {
            Adresses adressSaved = adressesService.saveAdresses(adress);
            return ResponseEntity.ok().body(adressSaved);
        }
        return ResponseEntity.badRequest().body(null);
    }


    @PostMapping("/user/{userName}/payment-mode")
    public ResponseEntity<PaymentMode>  savePaymentModeUser(@PathVariable String userName ,
                                                            @RequestBody PaymentMode paymentMode){
        PaymentMode paymentModeSaved=paymentModeService.savePaymentMode(paymentMode);
        User user=userService.getUser(userName);
        user.getPaymentMode().add(paymentMode);
        userService.saveUser(user);
        return ResponseEntity.ok().body(paymentMode);}

    @PutMapping("/user/{userName}/payment-mode/{paymentModeId}")
    public ResponseEntity<PaymentMode>  updatePaymentModeUser(@PathVariable("userName") String userName ,
                                                      @PathVariable("paymentModeId") Long id,
                                                      @RequestBody PaymentMode paymentMode) {
        Optional<PaymentMode> paymentModeFound = paymentModeService.findById(id);
        if (paymentModeFound.isPresent()) {
            PaymentMode paymentModeSaved = paymentModeService.savePaymentMode(paymentMode);
            return ResponseEntity.ok().body(paymentModeSaved);
        }
        return ResponseEntity.badRequest().body(null);
    }



    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }


    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token=authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username =decodedJWT.getSubject();
                User user =userService.getUser(username);
                String access_token= JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                response.setHeader("access_token", access_token);
                response.setHeader("refresh_token", refresh_token);
                Map<String,String> tokens= new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token",access_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            } catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String,String> error= new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }

        } else {
             throw new RuntimeException("Refresh token is missing");
        }
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}