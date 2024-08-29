package com.customer.rewardpoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RewardsExceptions {
    @ExceptionHandler(value = MonthOlderThanThreeException.class)
    public ResponseEntity<Object> exception(MonthOlderThanThreeException exception) {
        return new ResponseEntity<>("Month of purchase Older than three", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotCurrentYearException.class)
    public ResponseEntity<Object> exception(NotCurrentYearException exception) {
        return new ResponseEntity<>("This purchase is not of this year", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoTransactionMadeException.class)
    public ResponseEntity<Object> exception(NoTransactionMadeException exception) {
        return new ResponseEntity<>("No transaction made by this customer", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RecentTransactionException.class)
    public ResponseEntity<Object> exception(RecentTransactionException exception) {
        return new ResponseEntity<>("Transaction date is less than a month old", HttpStatus.NOT_FOUND);
    }


}
