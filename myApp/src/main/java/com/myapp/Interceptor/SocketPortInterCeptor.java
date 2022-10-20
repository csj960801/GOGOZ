package com.myapp.Interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 소켓포트전용 인터셉터
 * 
 * @author CSJ
 */
public class SocketPortInterCeptor extends HandlerInterceptorAdapter {

	private Logger socketinterceptorLog = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean socketFlag = false;

		String port = request.getParameter("portNum");
		// 포트 첫자리 검사
		String[] firstwordCheck = port.split("");
		int changeword = 0;
		// 만약 첫자리가 0일경우 1로 바꾼다
		if (firstwordCheck[0].equals("0")) {
			socketinterceptorLog.info("-----------------------");
			socketinterceptorLog.info("포트 첫자리가 0입니다. 1로 바꿉니다.");
			socketinterceptorLog.info("-----------------------");

			firstwordCheck[0] = "1";
			for (String convertport : firstwordCheck) {
				changeword = Integer.parseInt(convertport);
				if (firstwordCheck[0].equals("1")) {
					socketFlag = true;
				}

			}
		}
		// 아닐 경우 port변수로 전달받은 포트번호 전송
		else {
			socketFlag = true;
			changeword = Integer.parseInt(port);
		}

		return socketFlag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		socketinterceptorLog.info("============================");
		socketinterceptorLog.info("소켓전용컨트롤러접근");
		socketinterceptorLog.info("============================");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
