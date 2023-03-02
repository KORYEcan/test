package shop.mtcoding.mvcapp.controller;

import shop.mtcoding.mvcapp.config.ViewResovler;
import shop.mtcoding.mvcapp.model.Board;
import shop.mtcoding.mvcapp.model.BoardRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


// 책임: 클라이언트 요청(유효성 검사=validation check) 받고, 응답(VIew, Data)
public class BoardController {
  private  BoardRepository boardRepository;

//Controller -> Repository 필요로함
  //Controller는 Repository에 의존적이다.
  //의존적인 객체를 DS로 부터 주입받을 것이다.


  //초기화
  public BoardController(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }




  public String list(HttpServletRequest request){
    //C-M-V
       List<Board> boardList=boardRepository.findAll();

       request.setAttribute("boardList",boardList);
    return ViewResovler.resolve("/board/list");

  }

  public String saveForm(){
  //C-V
    return ViewResovler.resolve("/board/saveForm");

  }



  //스프링은 컨트롤러에 매개변수를 적기만 하면 formUrlencoded(디폴트) 데이터를 DS로부터 전달받음
  public  String save(String title, String content) {
    //검증 코드: httpmethod 4가지 중에!! POST PUT resource를 client로 부터 받으니깐

    if (title== null|| title.equals("")){
     throw new NullPointerException("title이 없습니다.");
    }

    if (content==null || content.equals("")){
      throw new NullPointerException("content이 없습니다");
    }

     boardRepository.save(title, content);
    return "/board/list.do" ;
  }





}
