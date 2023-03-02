package shop.mtcoding.mvcapp.model;

import shop.mtcoding.mvcapp.config.DB;

import java.util.List;

public class UserRepository {

  public User login(String username, String password){
    return DB.login(username, password);
  }
  public List<User> findAll(){
    return DB.selectAll1();
  }

  public void join(String username, String password, String email){
    DB.join(username, password, email);
  }

}
