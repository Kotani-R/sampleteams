package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.samplesDAO;

/**
 * Servlet implementation class Delete_User_Info
 */
@WebServlet("/Delete_User_Info")
public class Delete_User_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_User_Info() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// idで文字列を受け取る
		String userId = request.getParameter("id");
		// DAOをインスタンス化する
		samplesDAO samDAO = new samplesDAO();
		// 情報を削除する
		samDAO.DeleteUser(userId);
		// リダイレクト
		response.sendRedirect("ListView");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
