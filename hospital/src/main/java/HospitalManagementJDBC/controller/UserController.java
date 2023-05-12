package HospitalManagementJDBC.controller;

import HospitalManagementJDBC.product.Product;
import HospitalManagementJDBC.repository.UserRepository;
import HospitalManagementJDBC.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path = "/users")  // http://localhost:8081/users/
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/register") // POST:  http://localhost:8081/users/register/
    public @ResponseBody Hashtable registerUser(@RequestParam String name,
                                                @RequestParam String email,
                                                @RequestParam String userType,
                                                @RequestParam String password) {

        Hashtable<String, Object> response = new Hashtable<>();
        // check dublicate email user
        List<UserRepository.User> foundUsers = userRepository.findByEmail(email);
        if (foundUsers.size() > 0) {
            if (userType.equals("facebook")) {
                response.put("result", "oke");
                response.put("data", foundUsers.get(0));
                response.put("message", "Login user successfully");
                return response;
            } else {
                response.put("result", "failed");
                response.put("data", "");
                response.put("message", "User already exists");
                return response;
            }
        }

        User newUser = new User(name, email, userType, password);
        userRepository.save(newUser); // insert into database mysql
        response.put("result", "oke");
        response.put("data", newUser);
        response.put("message", "Register user Successfully");
        return response;
    }


    // should use token keys for more secure !
    @PostMapping(path = "/login") // GET:  http://localhost:8081/users/login/
    public @ResponseBody Hashtable login(@RequestParam String email,
                                         @RequestParam String password,
                                         @RequestParam String userType)  {
        Hashtable<String, Object> response = new Hashtable<>();
        try {
            if (userType.equals("facebook")) {
                List<UserRepository.User> foundUsers = userRepository.findByEmail(email);
                if (foundUsers.size() > 0) {
                    response.put("result", "oke");
                    response.put("data", foundUsers.get(0));
                    response.put("message", "Login user successfully");
                } else {
                    response.put("result", "failed");
                    response.put("data", "");
                    response.put("message", "Cannot find user");
                }
            } else {
                UserRepository.User foundUser = userRepository.findByEmailAndPassword(email, password);
                response.put("result", "oke");
                response.put("data", foundUser);
                response.put("message", "Login user successfully");
            }
        } catch(NoSuchElementException e) {
            response.put("result", "failed");
            response.put("data", "");
            response.put("message", "Cannot find user: Error" + e);
        } finally {
            return response;
        }
    }

}
