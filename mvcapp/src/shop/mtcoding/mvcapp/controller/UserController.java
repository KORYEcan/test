package shop.mtcoding.mvcapp.controller;

import shop.mtcoding.mvcapp.config.ViewResovler;
import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.User;
import shop.mtcoding.mvcapp.model.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

public class UserController {

  UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public String joinForm() {
    return ViewResovler.resolve("/user/joinForm");
  }


  public String loginForm() {
    return ViewResovler.resolve("/user/loginForm");
  }

  public String login(HttpServletRequest request) {
    List<User> userList=userRepository.findAll();
            String username=request.getParameter("username");
            String password= request.getParameter("password");

    if (username == null || username.equals("")) {
      throw new NullPointerException("username이 없습니다.");
    }
    if (password == null || password.equals("")) {
      throw new NullPointerException("password이 없습니다");
    }

    if(userRepository.login(username,password)==null){
      throw new NullPointerException("비밀번호가 틀렸습니다.");
    }

    userRepository.login(username,password);
    request.setAttribute("user",userList);



      return "/board/list.do";
  }



    public String join (String username, String password, String email){
      if (username == null || username.equals("")) {
        throw new NullPointerException("username이 없습니다.");
      }

      if (password == null || password.equals("")) {
        throw new NullPointerException("password이 없습니다");
      }
      if (email == null || email.equals("")) {
        throw new NullPointerException("email이 없습니다");
      }

      userRepository.join(username, password, email);
      return "/user/loginForm.do";
    }


  }

