package com.project.shopapp.services.impl;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Role;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import com.project.shopapp.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        String phoneNumber = userDTO.getPhoneNumber();
        // kiểm tra xem số điện thoại này đã đăng ký hay chưa
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new DataIntegrityViolationException("Phone number already exits");
        }
        Role role = roleRepository.findById(userDTO.getRoleId()).orElseThrow(
                () -> new DataNotFoundException("Role not found"));

        User user = User.builder()
                .fullName(userDTO.getFullName())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .active(true)
                .role(role)
                .build();
        //kiểm tra xem nếu có  có facebookAccountId || googleAccountId thì k cần password
        if (userDTO.getFacebookAccountId() == 0 && userDTO.getGoogleAccountId()==0){
            String password = userDTO.getPassword();
//            String encodePassword = passwordEncoder.encode(password);
//            user.setPassword(encodePassword);
        }

        return userRepository.save(user);
    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }
}
