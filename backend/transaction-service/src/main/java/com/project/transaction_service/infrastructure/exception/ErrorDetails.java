package com.project.transaction_service.infrastructure.exception;

import java.util.List;

public record ErrorDetails (
        int status,
        String message,
        List<String> erros
) {}
