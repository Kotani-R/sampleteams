package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.GetOneUser;
import object.userList;

/**
 * Servlet implementation class Choose_Id
 */
@WebServlet("/Choose_Id")
public class Choose_Id extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Choose_Id() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GetOneUserをインスタンス化
		GetOneUser getuser = new GetOneUser();
		// リストに情報を挿入
		List<userList> userlists = getuser.execute();
		// forwardPathを宣言
		String forwardPath = null;
		
		// for文の宣言
		for (userList user : userlists) {
			// idの文字列を受け取る
			String userId = request.getParameter("id");
			// if文でnull判定を行う
			if (userId == null) {
				forwardPath = "WEB-INF/jsp/listView.jsp";
			}
			else if (userId.equals(user.getId())) {
				// インスタンスをセットする
				request.setAttribute("user", user);
				forwardPath = "WEB-INF/jsp/userOne.jsp";
			}
		}
		// dispatcherでページ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
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
