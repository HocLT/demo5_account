package vn.aptech;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.aptech.dao.AccountDao;
import vn.aptech.entity.Account;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountDao dao = new AccountDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		if (a == null) {
			response.sendRedirect("login.jsp");
		} else {
			switch (a) {
			case "DisplayProduct": {
				request.setAttribute("accounts", dao.findAll());
				request.getRequestDispatcher("account/index.jsp").forward(request, response);
				break;
			}
			case "DisplayUpdate": {
				String id = request.getParameter("id");
				int nId = Integer.parseInt(id);
				Account account = dao.findById(nId);
				request.setAttribute("account", account);
				request.getRequestDispatcher("account/update.jsp").forward(request, response);
				break;
			}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		if (a != null) {
			switch (a) {
			case "Login": {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				if (dao.login(email, password) > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("username", email);
					response.sendRedirect("Controller?a=DisplayProduct");
				} else {
					// chuyển về trang thông báo lỗi
				}
				break;
			}
			case "Update": {
				String id = request.getParameter("id");
				int nId = Integer.parseInt(id);
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String role = request.getParameter("role");
				int nRole = Integer.parseInt(role);
				Account account = new Account();
				account.setId(nId);
				account.setEmail(email);
				account.setPhone(phone);
				account.setRole(nRole);
				dao.update(account);
				response.sendRedirect("Controller?a=DisplayProduct");
				break;
			}
			}
		}
	}

}
