package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.Attribute;

@Service
public interface CSVParser {
	
	public List<? extends Attribute> parse(MultipartFile file);

}
