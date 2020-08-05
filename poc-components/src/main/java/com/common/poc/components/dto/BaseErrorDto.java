package com.common.poc.components.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseErrorDto {

  private String code;
  private String title;
  private String detail;
  private String status;
}
