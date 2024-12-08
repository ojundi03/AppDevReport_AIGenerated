//package com.petso1.petso1.services;
//
//import com.petso1.petso1.entities.User;
//import com.petso1.petso1.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder; // For encoding passwords
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    // Create a new user
//    @Override
//    public User createUser(User user) {
//        // Check if username already exists
//        if (userRepository.existsByUsername(user.getUsername())) {
//            throw new IllegalArgumentException("Username already exists");
//        }
//        // Encode the password
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        // Set default role if not set
//        if (user.getRole() == null) {
//            user.setRole("ROLE_USER");
//        }
//        // Set unlocked status to true by default
//        user.setUnlocked(true);
//        // Save the user
//        return userRepository.save(user);
//    }
//
//    // Reset password
//    @Override
//    public void resetPassword(Long userId, String newPassword) {
//        User user = getUserById(userId);
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//    }
//
//    // Toggle unlocked status
//    @Override
//    public void toggleUnlockedStatus(Long userId) {
//        User user = getUserById(userId);
//        user.setUnlocked(!user.isUnlocked());
//        userRepository.save(user);
//    }
//
//    // Delete user
//    @Override
//    public void deleteUser(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    // Get user by ID
//    @Override
//    public User getUserById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));
//    }
//}
