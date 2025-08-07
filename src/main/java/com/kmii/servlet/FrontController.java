package com.kmii.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kmii.dto.BoardDto;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request -> mid, mpw 담아서 넘어온다 , 사용자가 요청한 주소도 포함
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); //사용자가 요청한 URI
		//System.out.println(uri);  // uri는 서버주소 뺀 값 : /jsp_webServlet_20250807/loginOk.do
		String con = request.getContextPath();  // 컨텍스트 패스 가져오기
		//System.out.println(con);   // /jsp_webServlet_20250807
		//uri-con 해주면 원하는 - /loginOk.do 추출 가능!
		String command = uri.substring(con.length());   // 컨텍스트 패스의 길이인덱스 부터 끝까지 추출
		System.out.println("클라이언트의 요청" + command);  // /loginOk.do  추출 
		HttpSession session = request.getSession(); // 세션을 선언(생성) , HttpSession는 인스턴스라 객체 만들지 못한다. - 그 안에 들어있는 session빼서 쓴다
		
		String viewPage = "";  // 실제 클라이언트에게 전송될 jsp파일의 이름이 저장될 변수
		
		if(command.equals("/loginOk.do")) {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			
			
		if(mid.equals("tiger") && mpw.equals("12345")) {
			
			session.setAttribute("sid", "mid");  // 세션에 id값 올리기 -> 로그인 상태로 변경
			//response.sendRedirect("welcome.jsp");  강제이동만 가능, request객체의 값을 가져가지 못함
			request.setAttribute("mid", mid);
			viewPage = "welcome.jsp";  // 로그인 성공 후 이동할 jsp설정
		  }	
		} else if (command.equals("/login.do")) {  //login.jsp로 이동
			viewPage = "login.jsp";
		
		}  else if (command.equals("/welcome.do")) {  //welcome.jsp로 이동
			viewPage = "welcome.jsp";
		
		}  else if (command.equals("/logout.do")) {
	   		session = request.getSession(); // 요청마다 request가 다를 수 있어서 따로빼서 써줘야한다.
	        session.invalidate(); 
	        request.setAttribute("errrorNsg", "로그아웃 후 다시 로그인 하시려면 아이디 비밀번호 입력하세여");
	    	viewPage = "login.jsp"; 
			
		} else if (command.equals("/freeboard.do")) {  //게시판 보여달라는 요청
			//게시판 더미 데이터로 만들기
			List<BoardDto> boardList = new ArrayList<BoardDto>();
			
			boardList.add(new BoardDto("날씨더워1", "이순신", "2025-08-07"));
			boardList.add(new BoardDto("날씨더워2", "김순신", "2025-08-06"));
			boardList.add(new BoardDto("날씨더워3", "박순신", "2025-08-05"));
			boardList.add(new BoardDto("날씨더워4", "최순신", "2025-08-05"));
			boardList.add(new BoardDto("날씨더워5", "정순신", "2025-08-04"));
			
			request.setAttribute("boardList", boardList);
			
			viewPage = "boardList.jsp";
			
			
		
		} else {  // 로그인 실패
			System.out.println("로그인실패"); 
			
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 틀렸습니다.");
		    viewPage = "login.jsp";
		}
		
		// response.sendRedirect(viewPage); // if문 끝나고 viewPage 값을 넣어 그 페이지로 이동가능 , 하지만 request 객체 포함 안된다!!
		
		// viewPage에 저장된 jsp페이지로 이동시킬때 request 객체를 포함해서 이동 시키는 방법
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);  // viewPage로 이동해줘
			dispatcher.forward(request, response);  // request의 객체까지 가져가
	}
		

		
		
}	


		

  

