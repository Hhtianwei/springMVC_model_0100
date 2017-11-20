package com.tim.spring.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.tim.spring.model.MyUser;


public class UserLoginJdbcDaoImpl extends JdbcDaoImpl
{

	private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT A.authority FROM AUTHORITIES AS A JOIN USERS AS U ON U.id = A.uid WHERE U.username=?";

	private static final String USERS_BY_USERNAME_QUERY = "select username,password,enabled,saltValue from users where username = ?";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		List users = loadUsersByUsername(username);
		if (users.size() == 0)
		{
			logger.debug(
					(new StringBuilder()).append("Query returned no results for user '").append(username).append("'").toString());
			throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound", new Object[]
			{ username }, "Username {0} not found"));
		}

		MyUser user = (MyUser) users.get(0);
		List auths = loadUserAuthorities(user.getUsername());

		if (auths == null || auths.size() == 0)
		{
			throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.noAuthority", new Object[]
			{ username }, "User {0} has no GrantedAuthority"));
		}

		List authString = new ArrayList();
		for (Object obj : auths)
		{
			Map<Object, Object> map = (Map<Object, Object>) obj;
			for (Map.Entry<Object, Object> m : map.entrySet())
			{
				authString.add(new SimpleGrantedAuthority((String) m.getValue()));
			}
		}

		Set dbAuthsSet = new HashSet();
		dbAuthsSet.addAll(authString);

		List dbAuths = new ArrayList(dbAuthsSet);

		if (dbAuths.size() == 0)
		{
			logger.debug((new StringBuilder()).append("User '").append(username)
					.append("' has no authorities and will be treated as 'not found'").toString());
			throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.noAuthority", new Object[]
			{ username }, "User {0} has no GrantedAuthority"));
		}
		else
		{
			return createUserDetails(username, user, dbAuths);
		}
	}

	@Override
	protected List loadUsersByUsername(String username)
	{
		return getJdbcTemplate().query(USERS_BY_USERNAME_QUERY, new String[]
		{ username }, new RowMapper<Object>()
		{
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				String username = rs.getString(1);
				String password = rs.getString(2);
				boolean enabled = rs.getBoolean(3);
				String saleValue = rs.getString(4);
				return new MyUser(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES, saleValue);
			}
		});
	}

	protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List combinedAuthorities)
	{
		MyUser u = (MyUser) userFromUserQuery;
		String saltValue = u.getSaltValue();
		User user = (User) super.createUserDetails(username, userFromUserQuery, combinedAuthorities);
		return new MyUser(user.getUsername(), userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), true, true, true,
				combinedAuthorities, saltValue);
	}

	protected List loadUserAuthorities(String username)
	{
		return getJdbcTemplate().queryForList(AUTHORITIES_BY_USERNAME_QUERY, new String[]
		{ username });
	}
}
