package com.cg.fms.global;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fms.exceptions.AirportCodeNotFoundException;
import com.cg.fms.exceptions.FlightCancelledException;
import com.cg.fms.exceptions.FlightNumberNotFoundException;
import com.cg.fms.exceptions.InvalidFlightException;
import com.cg.fms.exceptions.InvalidScheduledFlightException;
import com.cg.fms.exceptions.InvalidUserException;
import com.cg.fms.exceptions.NoAirportsFoundException;
import com.cg.fms.exceptions.NoScheduleFoundException;
import com.cg.fms.exceptions.RecordAlreadyPresentException;
import com.cg.fms.exceptions.ScheduledFlightNotFoundException;
import com.cg.fms.exceptions.UsersNotFoundException;
import com.cg.fms.response.ErrorInfo;
import com.cg.fms.exceptions.FlightNotFoundException;

@RestControllerAdvice
public class GlobalException{

	@ExceptionHandler
	public ResponseEntity<Map<String , String>> HandleException(MethodArgumentNotValidException e){
		Map<String , String> errorMap = new LinkedHashMap<>();
		List<FieldError> list = e.getFieldErrors();
		for(FieldError f : list){
			String fieldName = f.getField();
			String errorMsg = f.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);
			}
		ResponseEntity<Map<String , String>> rEntity = new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
		return rEntity;
		}

	@ExceptionHandler(AirportCodeNotFoundException.class)
	public ResponseEntity<ErrorInfo> HandlingException(AirportCodeNotFoundException e, HttpServletRequest request) {
		String msg = e.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(NoAirportsFoundException.class)
	public ResponseEntity<ErrorInfo> HandlingException(NoAirportsFoundException e, HttpServletRequest request) {
		String msg = e.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(InvalidFlightException.class)
	public ResponseEntity<ErrorInfo> handlingException(InvalidFlightException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(FlightNotFoundException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(FlightCancelledException.class)
	public ResponseEntity<ErrorInfo> handlingException(FlightCancelledException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(FlightNumberNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(FlightNumberNotFoundException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(InvalidScheduledFlightException.class)
	public ResponseEntity<ErrorInfo> handlingException(InvalidScheduledFlightException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	
	
	@ExceptionHandler(NoScheduleFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoScheduleFoundException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<ErrorInfo> handlingException(RecordAlreadyPresentException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(ScheduledFlightNotFoundException ex,HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(),msg, request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
		}
	
	
	@ExceptionHandler(UsersNotFoundException.class)

	public ResponseEntity<ErrorInfo> handlingException(UsersNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		ErrorInfo errInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, req.getRequestURI());
		ResponseEntity<ErrorInfo> Rentity = new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.NOT_FOUND);
		return Rentity;
	}

	@ExceptionHandler(InvalidUserException.class)

	public ResponseEntity<ErrorInfo> handlingException1(InvalidUserException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		ErrorInfo errInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, req.getRequestURI());
		ResponseEntity<ErrorInfo> Rentity = new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.NOT_FOUND);
		return Rentity;
	}
	


}
