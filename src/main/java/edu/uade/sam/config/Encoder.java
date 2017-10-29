package edu.uade.sam.config;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Encargado de encriptar la contraseña antes de guardarla en la DB
 * 
 * @author msarno
 *
 */
public class Encoder {
	
	private static final HashFunction ENCODER = Hashing.sha256();
	
	public static final String ENCODE(String password) {
		return ENCODER
		        .hashString(password, StandardCharsets.UTF_8)
		        .toString();
	}

}
