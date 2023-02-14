package com.ecommerce.mybookstore.service;

import com.ecommerce.mybookstore.entity.Adresses;
import com.ecommerce.mybookstore.repository.AdressesRepository;
import com.ecommerce.mybookstore.repository.RoleRepo;
import com.ecommerce.mybookstore.entity.Role;
import com.ecommerce.mybookstore.entity.User;
import com.ecommerce.mybookstore.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    private final AdressesRepository adressesRepository;


    @Override
    public User saveUser(User user,Boolean userNew) {
        log.info("Saving new user {} to the database", user.getName());
        if (userNew == true){
        user.setPassword(passwordEncoder.encode(user.getPassword()));}

        List<Adresses> listAdressOfUser= user.getAdresses();

        if (listAdressOfUser == null || (listAdressOfUser != null && listAdressOfUser.size()==0)) {
        Adresses adressToSave = new Adresses();

        adressToSave.setNameAdress(user.getName());
        adressToSave.setLastNameAdress(user.getLastName());
        adressToSave.setAdressPartOne(user.getAdressPartOne());
        adressToSave.setAdressPartTwo(user.getAdressPartTwo());
        adressToSave.setCity(user.getCity());
        adressToSave.setIsDeliveryAdress(true);
        adressToSave.setIsInvoiceAdress(true);
        adressToSave.setZip(user.getZip());

        Adresses adressSaved= adressesRepository.save(adressToSave);

        user.setAdresses(List.of(adressSaved)); }

        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}",roleName, username);
        User user=userRepo.findByUsername(username);
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetch user {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User>  getUserBB() {
        log.info("Fetch All user ");
        return userRepo.findAll();
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetch All user ");
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user==null){
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
