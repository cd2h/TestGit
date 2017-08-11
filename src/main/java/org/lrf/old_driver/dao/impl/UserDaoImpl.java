package org.lrf.old_driver.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lrf.old_driver.dao.UserDao;
import org.lrf.old_driver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;


@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate templte;

	private static final Log log = LogFactory.getLog(UserDaoImpl.class);

	@Override
	public boolean insertUser(User user) {
		try {
			templte.insert(user);
			log.info("insert:" + user.toString());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	@Override
	public User findUser(User condition) {

		Query query = new Query();

		if (condition.getId() != null && !condition.getId().isEmpty())
			query.addCriteria(where("id").is(condition.getId()));
		
		if (condition.getUserName() != null && !condition.getUserName().isEmpty())
			query.addCriteria(where("userName").is(condition.getUserName()));

		if (condition.getCellPhone() != null && !condition.getCellPhone().isEmpty())
			query.addCriteria(where("cellPhone").is(condition.getCellPhone()));

		if (condition.getPassWord() != null && !condition.getPassWord().isEmpty())
			query.addCriteria(where("passWord").is(condition.getPassWord()));

		return templte.findOne(query, User.class);
	}

	@Override
	public User updateUser(User user) {

		Query query = new Query();

		if (user.getId() != null && !user.getId().isEmpty())
			query.addCriteria(where("id").is(user.getId()));

		Update update = new Update();

		if (user.getPassWord() != null && !user.getPassWord().isEmpty())
			update.setOnInsert("passWord", user.getPassWord());

		if (user.getIntroduce() != null && !user.getIntroduce().isEmpty())
			update.setOnInsert("introduce", user.getIntroduce());

		WriteResult writeResult = templte.updateFirst(query, update, User.class);
		
		return this.findUser(new User(writeResult.getUpsertedId().toString()));

	}

}
