package com.ctb.pilot.chat.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.chat.model.Message;

public interface MessageMapper {

	List<Message> getMessages(@Param("pageSize") int pageSize,
			@Param("offset") int offset);

	void insertMessage(@Param("userSequence") int userSequence,
			@Param("message") String message, @Param("language") String language);

	long getAllMessageCount();

}
