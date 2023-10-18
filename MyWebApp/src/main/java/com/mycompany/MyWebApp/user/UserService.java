package com.mycompany.MyWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //service class
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }
    public User get (Integer id){
        Optional<User> result=repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        try {
            throw new UserNotFoundException("Could not find any user with ID "+id);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count=repo.countById(id);
        if(count==null || count==0){
            throw new UserNotFoundException("Could not find any user with ID "+id);

        }

        repo.deleteById(id);
    }
}
