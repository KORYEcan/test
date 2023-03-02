package shop.mtcoding.mvcapp.config;

import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class DB {
  private static List<Board> boardlist= new ArrayList<>();
  private static List<User>  userlist= new ArrayList<>();

  static {
    boardlist.add(new Board( 1,"제목","내용"));
    boardlist.add(new Board( 2,"제목","내용"));
    userlist.add(new User(1,"kim","qwer1234","apple12@naver.com"));
    userlist.add(new User(2,"park","qwer1234","banana45@naver.com"));
  }



public static List<Board> selectAll(){
    return boardlist;
}

public static void insert(String title, String content){
    int id = boardlist.size()+1;
   boardlist.add(new Board(id,title, content));
  }


public static void join(String username, String password, String email){
      int id= userlist.size()+1;
      userlist.add(new User(id,username,password,email));
}

public static List<User> selectAll1(){ return userlist;}

public static User login(String username, String password){

    for(User user: userlist) {
      if(user.getUsername().equals(username)&& user.getPassword().equals(password)){
        return  user;
      }

      if( !(user.getUsername().equals(username))&& !(user.getPassword().equals(password))){
        return null;
      }
    }


return null;
}

}
