package com.maersk.commons.component.exception;

import com.maersk.commons.component.dto.BaseErrorDto;
import lombok.Data;

import java.util.List;

@Data
public class BusinessException extends RuntimeException {

  private final List<BaseErrorDto> errors;

  public BusinessException(List<BaseErrorDto> errors) {
    this.errors = errors;
  }

  public BusinessException(List<BaseErrorDto> errors, Throwable cause) {
    super(cause);
    this.errors = errors;
  }
}
