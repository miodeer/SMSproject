package cn.ekgc.sms.service.impl;

import cn.ekgc.sms.dao.ClassroomDao;
import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.SystemPage;
import cn.ekgc.sms.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomDao classroomDao;

	public SystemPage<Classroom> getClassroomPage(SystemPage<Classroom> systemPage) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		//分页条件
		queryMap.put("begin", systemPage.getBegin());
		queryMap.put("size", systemPage.getSize());

		//班级列表
		List<Classroom> list = classroomDao.findClassroomListByQuery(queryMap);
		//移除limit条件
		queryMap.put("begin", null);
		queryMap.put("size", null);
		//获得总条数
		Long totalSize = (long) classroomDao.findClassroomListByQuery(queryMap).size();

		systemPage.setList(list);
		systemPage.setTotalSize(totalSize);
		systemPage.setTotalPage();
		return systemPage;
	}
}
