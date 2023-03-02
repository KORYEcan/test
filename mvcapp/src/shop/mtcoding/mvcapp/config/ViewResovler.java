package shop.mtcoding.mvcapp.config;

public class ViewResovler {
  private static String prefix= "/WEB-INF/views";
  private static String suffix= ".jsp";


public static String resolve(String name){  // /board/lsit
  // /WEB-INF/views/board/list.jsp
  return prefix+name+suffix;
}


}
