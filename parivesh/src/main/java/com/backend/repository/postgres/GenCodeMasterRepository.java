package com.backend.repository.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.model.GenCodeMaster;

public interface GenCodeMasterRepository extends JpaRepository<GenCodeMaster, Long>{

	@Query("Select g from GenCodeMaster g where parent_grp = ?1")
	List<GenCodeMaster> findAllByParentGrp(String group);
}
