package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("user")
public class UserController {

    UserData userData = new UserData();

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(verify != null && !verify.equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "The password doesn't match the confirmation field.");
            return "user/add";
        }
        userData.add(user);
        model.addAttribute("user", user);
        model.addAttribute("usersList", userData.getAll());
        return "user/index";
    }

    @GetMapping("{id}/view")
    public String displayUserDetailsView(Model model, @PathVariable int id) {
        User user = userData.getById(id);
        if(user == null) {
            model.addAttribute("error", "There is no user with the Id provided.");
        } else {
            model.addAttribute("user", user);
        }
        return "user/view";
    }
}
