package com.common.poc.components.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BaseErrorDto implements Serializable {

  private String code;
  private String title;
  private String detail;
  private String status;
}
