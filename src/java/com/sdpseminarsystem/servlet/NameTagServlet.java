package com.sdpseminarsystem.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.nametag.NameTag;
import com.sdpseminarsystem.vo.Attendee;

/**
 * Servlet implementation class NameTagServlet
 */
@WebServlet("/NameTagServlet")
public class NameTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NameTagServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			final String DOWNLOAD_FILE_NAME = "name_tag.pdf";

			int seminarId = Integer.valueOf(request.getParameter("seminarId"));
			List<Attendee> attendees = DAOFactory.getInstanceOfAttendeeDAO().findAllBySeminar(seminarId);

			String root = request.getServletContext().getRealPath("/file");
			String fileName = UUID.randomUUID().toString() + ".pdf";
			String filePath = root + "\\" + fileName;
			NameTag.makeFile(filePath, attendees);

			String mimeType = getServletContext().getMimeType(filePath);
			response.setContentType(mimeType);

			File file = new File(filePath);
			Long length = file.length();
			response.setContentLength(length.intValue());

			fileName = URLEncoder.encode(file.getName(), "UTF-8");
			response.addHeader("Content-Disposition", "attachment; filename=" + DOWNLOAD_FILE_NAME);

			FileInputStream fileInputStream = new FileInputStream(file);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

			int size = 0;
			byte[] bytes = new byte[4096];
			while((size = bufferedInputStream.read(bytes)) != -1)
				servletOutputStream.write(bytes, 0, size);

			servletOutputStream.flush();
			servletOutputStream.close();
			bufferedInputStream.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
