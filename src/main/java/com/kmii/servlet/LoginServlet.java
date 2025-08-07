package com.kmii.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginOk")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("로그인 호출 <br>");
		String id =	request.getParameter("id");
		//System.out.println("login.jsp에서 넘겨 받은 id값 :" + id);
		String pw = request.getParameter("pw");
		//System.out.println("login.jsp에서 넘겨 받은 pw값 :" + pw);
		
		if(id.equals("tiger") && pw.equals("12345")) {   // true면 로그인 성공
			// session에 id값을 저장하는게 로그인 성공
			HttpSession session = request.getSession();  // 세션 성공 // 여기서 session은 jsp처럼 내장객체가 아니라서 선언하고 써줘야한다 
			//넘겨받은 request객체  안에 session들어ㅏ 있어서 getsession으로 빼주고 쓴다
			session.setAttribute("id", id);  // 세션에 id 올리기
			response.sendRedirect("welcome.jsp");
		} else {
			//response.sendRedirect("loginFail.jsp");
			request.setAttribute("fid",id);  // 잘못된 id값
			request.getRequestDispatcher("loginFail.jsp").forward(request, response);		
			//request에 담긴 fid값 담아서 간다
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
