package com.ashokit.exception;

import java.time.LocalDateTime;

public class ExceptionInfo {

    private String exceptionCode;
    private String exceptionDescription;
    private LocalDateTime exceptionLocalDateTime;

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    public LocalDateTime getExceptionLocalDateTime() {
        return exceptionLocalDateTime;
    }

    public void setExceptionLocalDateTime(LocalDateTime exceptionLocalDateTime) {
        this.exceptionLocalDateTime = exceptionLocalDateTime;
    }
}
