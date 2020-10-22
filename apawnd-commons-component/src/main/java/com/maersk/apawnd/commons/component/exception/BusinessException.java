package com.maersk.apawnd.commons.component.exception;

import com.maersk.apawnd.commons.component.dto.BaseErrorDto;
import lombok.Data;

import java.util.List;

@Data
public class BusinessException extends RuntimeException {

  private final List<BaseErrorDto> errors;


  public BusinessException(List<BaseErrorDto> errors) {
    this.errors = errors;
  }

  public BusinessException(String message) {
    super(message);
    this.errors = null;
  }

  public BusinessException(List<BaseErrorDto> errors, String message) {
    super(message);
    this.errors = errors;
  }

  public BusinessException(List<BaseErrorDto> errors, Throwable cause) {
    super(cause);
    this.errors = errors;
  }

  public BusinessException(List<BaseErrorDto> errors, String message, Throwable cause) {
    super(message, cause);
    this.errors = errors;
  }
}
