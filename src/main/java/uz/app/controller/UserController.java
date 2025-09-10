package uz.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.app.dao.UserDao;
import uz.app.entity.User;
import uz.app.entity.enums.Roles;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/users")
public class UserController extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUser = userDao.getAllUser();
        req.setAttribute("users", allUser);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        LocalDateTime created_at = LocalDateTime.now();
        LocalDateTime updated_at = LocalDateTime.now();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAddress(address);
        user.setCreated_at(created_at);
        user.setUpdated_at(updated_at);
        user.setRole(Roles.USER);
        user.setPhone(phone);
        userDao.saveUser(user);
        resp.sendRedirect("/users");

    }
}
