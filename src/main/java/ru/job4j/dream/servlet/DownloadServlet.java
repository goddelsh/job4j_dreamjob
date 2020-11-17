package ru.job4j.dream.servlet;

import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        String path = "";
        if(req.getParameter("id") != null) {
            path = req.getParameter("id") + File.separator;
            name = PsqlStore.instOf().getImage(Integer.parseInt(req.getParameter("id")));
        } else {
            name = req.getParameter("name");
        }
        resp.setContentType("name=" + name);
        resp.setContentType("image/png");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        File file = new File("images" + File.separator + path + name);
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file)) {
                resp.getOutputStream().write(in.readAllBytes());
            }
        } else {
            try (FileInputStream in = new FileInputStream(new File("images" + File.separator + "empty.jpg"))) {
                resp.getOutputStream().write(in.readAllBytes());
            }
        }
    }
}
