package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.model.Message;

@Repository
public interface IMessage extends JpaRepository<Message, Integer>{
	@Query("select m from Message m where m.user_send.id=:x")
	public List<Message> getAllMessagesSendByIdUser(@Param("x")Integer id) ;



	@Query("select m from Message m where m.user_receive.id=:x")
	public List<Message> getAllMessagesRecusByIdUser(@Param("x")Integer id) ;
}
