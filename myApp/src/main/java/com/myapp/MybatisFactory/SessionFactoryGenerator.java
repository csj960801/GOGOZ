package com.myapp.MybatisFactory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFactoryGenerator {

	private static SqlSessionFactory sessionfactory;
	private static Logger sessionlog = LoggerFactory.getLogger(SessionFactoryGenerator.class);

	public static SqlSessionFactory sessionFactoryInstance() {
		String mybatisConfig = "mybatis-config.xml";
		InputStream ConfigStream = null;
		if (sessionfactory == null) {
			try {
				ConfigStream = Resources.getResourceAsStream(mybatisConfig);
				sessionfactory = new SqlSessionFactoryBuilder().build(ConfigStream);
			} catch (Exception e) {
				sessionlog.warn("SessionFactoryLoadingError: " + e.toString());
			}
		}
		return sessionfactory;
	}

}
