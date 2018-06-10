package api.service.impl;

import api.entity.Role;
import api.entity.User;
import api.logging.LogUserRegistration;
import api.repository.RoleRepository;
import api.repository.UserRepository;
import api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;


@Service
public class UserServiceImpl implements UserService {


    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @LogUserRegistration
    public void saveUser(User user) {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setEnabled(true);
        Role role = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        userRepository.save(user);
    }
}
