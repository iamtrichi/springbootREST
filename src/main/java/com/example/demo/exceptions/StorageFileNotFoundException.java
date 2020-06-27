package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StorageFileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public StorageFileNotFoundException() {
		super("Storage not found");
	}
}
