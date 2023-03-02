package shop.mtcoding.mvcapp;

import shop.mtcoding.mvcapp.config.DB;
import shop.mtcoding.mvcapp.controller.BoardController;
import shop.mtcoding.mvcapp.controller.UserController;
import shop.mtcoding.mvcapp.model.BoardRepository;
import shop.mtcoding.mvcapp.model.User;
import shop.mtcoding.mvcapp.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*
* GET-> http://localhost;20000/board/list.do
* GET-> http://localhost;20000/board/saveForm.do
* POST-> http://localhost;20000/board/save.do
*
*
*
* */




@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1. 버퍼로 들어오는 모든 값을 UTF-8fh 인코딩해서 받기(공통처리)
       req.setCharacterEncoding("utf-8");

       //2. path를 파싱
     String path=getPath(req);
    System.out.println("path : "+path);

    //3.action 파싱
   String action=getAction(req);
    System.out.println("action : "+action);



    //4. 컨트롤러 객체 생성

    BoardController boardCon= new BoardController(new BoardRepository());   //DI(의존성 주입)
    UserController UserCon= new UserController(new UserRepository());   //DI (의존성 주입)




    //5. Board 라우팅하기
    if(path.equals("board")) {
      switch (action) {
        case "saveForm":
          String saveFormView = boardCon.saveForm();
          req.getRequestDispatcher(saveFormView).forward(req, resp);
          break;

        case "save": //POST로 게시글 쓰기 요청(content, title)
          String method = req.getMethod();
          if (!method.equals("POST")) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().println("POST로 요청해야합니다.");
            break;
          }
          String title = req.getParameter("title");
          String content = req.getParameter("content");
          String saveRedirect = boardCon.save(title, content);
          resp.sendRedirect(saveRedirect);
//          req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req,resp);   //실습 꼭해보기
          break;

        case "list": //GET 요청이기떄문에  list목록을 보여주면 됨
          //MVC에 위임하는 코드
          String listView = boardCon.list(req);
          req.getRequestDispatcher(listView).forward(req, resp);
          break;

        default:  //이 "/board/list.do" 메인페이지로 지정
          resp.sendRedirect("/board/list.do");  //case list로 가라


      }
    }

      //5. User라우팅하기
      if (path.equals("user")){
        switch (action){
          case "joinForm":
           String joinFormView=UserCon.joinForm();
            req.getRequestDispatcher(joinFormView).forward(req,resp);
            break;

          case "loginForm":
            String UserloginFormView=UserCon.loginForm();
            req.getRequestDispatcher(UserloginFormView).forward(req,resp);
            break;

          case "login":
            String method= req.getMethod();
            if(!method.equals("POST")){
              resp.setContentType("text/html; charset=uft-8");
              resp.getWriter().println("POST로 요청해야합니다.");
              break;
            }
            String loginRedirect=UserCon.login(req);
            resp.sendRedirect(loginRedirect);
            break;

          case "join":
            String method1= req.getMethod();
            if(!method1.equals("POST")){
              resp.setContentType("text/html; charset=uft-8");
              resp.getWriter().println("POST로 요청해야합니다.");
              break;
            }
            String username1=req.getParameter("username");
            String password1=req.getParameter("password");
            String email1 =req.getParameter("email");
            String joinRedirect=UserCon.join(username1,password1,email1);
            resp.sendRedirect(joinRedirect);
            break;

          default:
            resp.sendRedirect("/user/joinForm.do");
        }
      }



    }




  private String getAction(HttpServletRequest req){
    String action= getUri(req).split("/")[1];
    action=action.replace(".do","");
    //System.out.println(action);
    return action; //list
  }
  private String getPath(HttpServletRequest req) {

    //board/list.do
    String path= getUri(req).split("/")[0];
    return path;

  }

  private String getUri(HttpServletRequest req){
    String uri= req.getRequestURI();
    uri= uri.substring(1);
    return uri;
  }

}
