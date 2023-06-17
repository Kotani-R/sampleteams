package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.SelectUser;
import object.userList;

/**
 * Servlet implementation class listController
 */
@WebServlet("/ListView")
public class ListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListView() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// SelectUserをインスタンス化
		SelectUser selectUser = new SelectUser();
		// データをリストに挿入
		List<userList> userlist = selectUser.execute();
		// インスタンスをリクエストスコープにセット
		request.setAttribute("userlist", userlist);
		// dispatcherで偏移先を指定
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/listView.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
