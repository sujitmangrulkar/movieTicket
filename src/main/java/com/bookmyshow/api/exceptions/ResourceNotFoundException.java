package com.bookmyshow.api.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException
{
    String resourceName;
    String fieldName;
    UUID fieldValue;
    String fieldValue1;
    public ResourceNotFoundException(String resourceName,String fieldName,UUID fieldValue)
    {
        super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldValue ));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue1)
    {
        super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldValue1 ));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
