package edu.uade.sam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.uade.sam.model.Result;

public interface ResultRepository extends CrudRepository<Result, Long> {

	public List<Result> findBySamId(long samId);

}
