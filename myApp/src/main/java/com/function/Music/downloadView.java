package com.function.Music;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//이 파일에서 다운로드 처리를 진행할 것이며 bean등록 처리를 하기 위해 BeanNameViewResolver를 사용
public class downloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		File file = (File) model.get("downloadFile");
		if (file != null) {
			String fileName = null;
			String userAgent = request.getHeader("User-Agent"); // 브라우저 정보

			if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1) {

				fileName = URLEncoder.encode(file.getName(), "utf-8").replaceAll("\\+", "%20");

			} else if (userAgent.indexOf("Chrome") > -1 || userAgent.indexOf("chrome") > -1) {

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < file.getName().length(); i++) {
					char c = file.getName().charAt(i);
					if (c > '~') {
						sb.append(URLEncoder.encode("" + c, "UTF-8"));
					} else {
						sb.append(c);
					}
				}
				fileName = sb.toString();

			} else {
				fileName = new String(file.getName().getBytes("utf-8"));
			}

			response.setContentType(getContentType());
			response.setContentLength((int) file.length());

			// 헤더에 괄호에 있는 내용을 추가해 데이터를 응답형식으로 보냄(그래서 url을 확인해보면 괄호에 설정한 내용이 들어가있음.)
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				FileCopyUtils.copy(fis, out);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (out != null) {
					out.flush();
				}
			}

		}
	}
}