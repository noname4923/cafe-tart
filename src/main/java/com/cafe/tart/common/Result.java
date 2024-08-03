package com.cafe.tart.common;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
  
  @Builder.Default
  private int status = 200;
  @Builder.Default
  private String message = "Success";
  private long elapsedTime;
  private LocalDateTime timestamp;
  private T data;

  public Result<T> buildMessage() {
    if (this.status != 200) {
      this.message = "Failure";
    }
    
    return this;
  }
  
}
