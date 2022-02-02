package com.example.demo.Exp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{
	
	
	private static final long serialVersionUID=1l;
	
	public ResourceNotFound(String m) {
		super(m);
	}

}
