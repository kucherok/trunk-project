package by.kucher.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.kucher.project.model.Syscomm;

public interface SysCommRepository extends JpaRepository<Syscomm, Integer> {

	@Query(value = "SELECT s.playerguid, COUNT(s.msgid) as nicknameAmount "
			+ "FROM Syscomm s LEFT JOIN s.playerguid p "
			+ "WHERE s.msgts BETWEEN :msgtsStart AND :msgtsFinish " + "AND s.eventtype = :eventtype "
			+ "GROUP BY p ")
	public List<Object[]> dailyActivity(@Param("msgtsStart") Long msgtsStart,
			@Param("msgtsFinish") Long msgtsFinish, @Param("eventtype") String eventtype);

}
