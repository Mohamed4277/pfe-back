package com.ecommerce.mybookstore.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecommerce.mybookstore.entity.*;
import com.ecommerce.mybookstore.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class UserResource {
    private final UserService userService;
    private final AdressesService adressesService;
    private final PaymentModeService paymentModeService;
    private final WishListService wishListService;
    private final OrderService orderService;
    private final ProductOrderService productOrderService;

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

    @GetMapping("/user/{id}/orders")
    public ResponseEntity<List<List<ProductOrder>>> getProductOrderByUserId(@PathVariable("id")  Long id){

        List<OrderF> order=orderService.findByUserId(id);

        List<List<ProductOrder>> productOrders=order.stream().map(ord->productOrderService.findByOrder(ord))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(productOrders);
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUserRegister(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        User userSaved =userService.saveUser(user);
        userService.addRoleToUser(userSaved.getUsername(),"ROLE_USER");
        return ResponseEntity.created(uri).body(userSaved);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/user/{userName}/adress")
    public ResponseEntity<Adresses> saveAdressUser(@PathVariable String userName , @RequestBody Adresses adress){
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

    @PostMapping("/user/{userName}/wish-list")
    public ResponseEntity<WishList>  saveWishListUser(@PathVariable String userName , @RequestBody Product product){
        User user=userService.getUser(userName);
        if (user.getWhishList()!=null)
        {user.getWhishList().getProduct().add(product);}
        else {
            WishList wishListSaved=wishListService.saveWishList(new WishList("My wish list",Arrays.asList(product)));
            user.setWhishList(wishListSaved);
        }
        userService.saveUser(user);
        return ResponseEntity.ok().body(user.getWhishList());}

    @DeleteMapping("/user/{userName}/wish-list")
    public ResponseEntity<WishList>  deleteWishListUser(@PathVariable String userName , @RequestBody Product product){
        User user=userService.getUser(userName);
        if (user.getWhishList()!=null && user.getWhishList().getProduct().size() > 1)
        {user.getWhishList().getProduct().remove(product);}
        else {
            user.getWhishList().getProduct().remove(product);
            user.setWhishList(null);
        }
        userService.saveUser(user);
        return ResponseEntity.ok().body(user.getWhishList());}

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