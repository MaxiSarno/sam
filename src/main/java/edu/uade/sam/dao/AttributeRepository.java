package edu.uade.sam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.uade.sam.model.NumericAttribute;

public interface AttributeRepository extends CrudRepository<NumericAttribute, Long> {

	public List<NumericAttribute> findBySamId(long samId);

}
