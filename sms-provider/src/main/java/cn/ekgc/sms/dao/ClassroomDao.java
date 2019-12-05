package cn.ekgc.sms.dao;

import cn.ekgc.sms.pojo.entity.Classroom;

import java.util.List;
import java.util.Map;

public interface ClassroomDao {
	//dao层获取班级列表
	List<Classroom> findClassroomListByQuery(Map<String, Object> queryMap) throws Exception;
}
