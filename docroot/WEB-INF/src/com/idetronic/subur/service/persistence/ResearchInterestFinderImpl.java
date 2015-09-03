package com.idetronic.subur.service.persistence;

import java.util.List;

import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.model.impl.ResearchInterestImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ResearchInterestFinderImpl extends BasePersistenceImpl<Expertise>
implements ResearchInterestFinder{
	
	public List<ResearchInterest> filterFindByG_N(long[] groupIds,String name,
			int start,int end,OrderByComparator obc) throws SystemException
	{
		Session session = null;
		try {
			session = openSession();
			
			
			String sql = CustomSQLUtil.get(FIND_BY_G_N);

			sql = StringUtil.replace(
				sql, "[$GROUP_ID$]", getGroupIds(groupIds));
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			
			
			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Subur_ResearchInterest", ResearchInterestImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			
			
			qPos.add(groupIds);
			qPos.add(name);
			qPos.add(name);

			return (List<ResearchInterest>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	
	}
	
	protected String getGroupIds(long[] groupIds) {
		if (groupIds.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(groupIds.length * 2);

		sb.append(StringPool.OPEN_PARENTHESIS);

		for (int i = 0; i < groupIds.length; i++) {
			sb.append("groupId = ?");

			if ((i + 1) < groupIds.length) {
				sb.append(" OR ");
			}
		}

		sb.append(") AND");
		
		
		return sb.toString();
	}
	
	public static final String FIND_BY_G_N = ResearchInterestFinder.class.getName() + ".findByGroupName";
	private static Log _log = LogFactoryUtil.getLog(ResearchInterestFinderImpl.class);

}
