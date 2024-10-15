package vn.iotstar.controllers.admin;

import static vn.iotstar.utils.Constant.DIR;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.services.IVideoService;
import vn.iotstar.services.impl.VideoService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/edit", "/admin/video/delete",
		"/admin/video/insert","/admin/video/update" })

public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IVideoService videoService = new VideoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();

		if (url.contains("videos")) {
			List<Video> list = videoService.findAll();
			req.setAttribute("listvideo", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);

		} else if (url.contains("edit")) {

			String videoid = req.getParameter("videoid");
			Video videoentity = videoService.findById(videoid);
			req.setAttribute("Video", videoentity);

			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {

			String videoid = req.getParameter("videoid");
			try {
				videoService.delete(videoid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();

		if (url.contains("insert")) {

			Video videoentity = new Video();

			String videoid = req.getParameter("videoid");
			int active = Integer.parseInt(req.getParameter("active"));
			String description = req.getParameter("description");
			String title = req.getParameter("title");

			videoentity.setVideoId(videoid);
			videoentity.setActive(active);
			videoentity.setDescription(description);
			videoentity.setTitle(title);

			String fname = "";
			String uploadPath = DIR;
			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// up load file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					videoentity.setPoster(fname);
				} else {
					videoentity.setPoster("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			videoService.insert(videoentity);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		} else if (url.contains("update")) {

			Video videoentity = new Video();

			String videoid = req.getParameter("videoid");
			int active = Integer.parseInt(req.getParameter("active"));
			String description = req.getParameter("description");
			String title = req.getParameter("title");

			videoentity.setVideoId(videoid);
			videoentity.setActive(active);
			videoentity.setDescription(description);
			videoentity.setTitle(title);

			String fname = "";
			String uploadPath = DIR;
			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// up load file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					videoentity.setPoster(fname);
				} else {
					videoentity.setPoster("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			videoService.update(videoentity);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		}
	}

}
