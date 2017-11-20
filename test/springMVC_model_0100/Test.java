package springMVC_model_0100;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Test
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:connectionDB.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		System.out.println("jdbcTemplate:" + jdbcTemplate.toString());
	}

}
