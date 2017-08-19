package edu.uade.sam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uade.sam.model.Design;

/**
 * @author msarno
 *
 */
public interface DesignRepository extends JpaRepository<Design, Long> {

}
