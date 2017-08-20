package edu.uade.sam.utils.csv;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.uade.sam.model.NumericAttribute;

@Service
public interface CSVParser {

	public List<NumericAttribute> parseNumeric(long samId, MultipartFile file);

}
