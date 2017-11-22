package springMVC_model_0100;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tim.spring.common.dao.CommonDAO;
import com.tim.spring.model.UserModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest
{

	@Autowired
	private CommonDAO commonDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void test()
	{
		JdbcTemplate jdbcTemplate = commonDao.getJdbcTemplate();
		String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";

		List<Map<String, Object>> list2 = jdbcTemplate.queryForList(sql, "tim-2", "67738a7f2eb04661827a8949b9fc1d1c");
		UserModel userModel = new UserModel();
		for (Map<String, Object> map : list2)
		{
			int id = (int) map.get("id");
			String name = (String) map.get("username");
			String mobile = (String) map.get("mobile");
			userModel.setId(id);
			userModel.setName(name);
			userModel.setMobile(mobile);
		}
		System.out.println(ReflectionToStringBuilder.toString(userModel));
	}

	@Test
	public void test2()
	{
		Session session = commonDao.getSessionFactory().openSession();
		System.out.println(session);
		String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, "tim-2");
		query.setParameter(1, "67738a7f2eb04661827a8949b9fc1d1c");
		query.addEntity(UserModel.class);
		List list = query.list();
		System.out.println("list:" + ReflectionToStringBuilder.toString(list.get(0)));
	}

	@Test
	public void test3()
	{
		String password = "1";
		System.out.println(passwordEncoder.encode(password));
		System.out.println(passwordEncoder.matches(password, "$2a$10$O7hm1b1fO35xQQc5b.BrauyGTx3WRf3eWxWLDhTyKP.wzsTY56gCC"));
	}
	//$2a$10$CtVh9kUVQpoRI8OHgnrlbuNRpk78UP3XyPCnbPvHVbafvyvViXgZi
	//$2a$10$O7hm1b1fO35xQQc5b.BrauyGTx3WRf3eWxWLDhTyKP.wzsTY56gCC
}
