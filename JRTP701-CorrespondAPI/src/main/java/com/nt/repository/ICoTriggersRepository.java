package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoTriggersEntity;

public interface ICoTriggersRepository extends JpaRepository<CoTriggersEntity, Integer> {
	public CoTriggersEntity findByCaseNo(Integer caseNo);
	
	public List<CoTriggersEntity> findByTriggerStatus(String triggerStatus);

}
