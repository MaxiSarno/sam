package edu.uade.sam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uade.sam.model.NumericAttribute;

/**
 * @author msarno
 *
 */
public interface AttributeRepository extends CrudRepository<NumericAttribute, Long> {

	public List<NumericAttribute> findBySamId(long samId);
	
	@Transactional
	public void deleteBySamId(long samId);

}
