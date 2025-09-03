package com.busramestan.firstSpringBoot.service;

import com.busramestan.firstSpringBoot.dto.request.UserRequest;
import com.busramestan.firstSpringBoot.dto.response.UserResponse;
import com.busramestan.firstSpringBoot.entity.User;
import com.busramestan.firstSpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse saveUser(UserRequest userRequest) {
        User user =new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAge(userRequest.getAge());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAge(user.getAge());
        return userResponse;
    }

    public Page<UserResponse> getAllUsers(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        return userRepository.findAll(pageable)
                .map(user -> {
                    UserResponse response = new UserResponse();
                    response.setName(user.getName());
                    response.setEmail(user.getEmail());
                    response.setAge(user.getAge());
                    return response;
                });
    }

    public UserResponse getUserById(Long id) {
        User user =  userRepository.findById(id).orElse(null);
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAge(user.getAge());
        return response;
    }

    public UserResponse updateUser(Long id, UserRequest userRequest){
        User user = userRepository.findById(id).orElse(null);
        if (user!= null) {
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setAge(userRequest.getAge());
            userRepository.save(user);

            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setEmail(user.getEmail());
            userResponse.setAge(user.getAge());
            return userResponse;
        }
        else {
            throw new RuntimeException("Update user not found: " +id);
        }
    }

    public void deleteUser (Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

}
