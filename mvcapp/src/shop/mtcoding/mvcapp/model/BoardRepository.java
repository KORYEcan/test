package shop.mtcoding.mvcapp.model;



// 책임 : 데이터 베이스 접근

import shop.mtcoding.mvcapp.config.DB;

import java.util.List;

public class BoardRepository {

  public List<Board> findAll(){
    //SELECT * FROM board
    return DB.selectAll();

  }


  //클라이언트(formUrlencodeed)-> DS(DispathcherServlet)파싱해서 (request body) -> controller(title,content)-> Repository(title,content)
  public void save(String title ,String content){
    //INSERT INTO board(title,content) VALUES('제목1','내용1')
      DB.insert(title, content);
  }
}
