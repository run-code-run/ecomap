package api.service;

import api.entity.User;

public interface UserService {

    public User findUserByEmail(String email);


    public void saveUser(User user);

}
