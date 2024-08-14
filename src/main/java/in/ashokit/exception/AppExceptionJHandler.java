package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionJHandler {

	@ExceptionHandler(value=SsaWebException.class)
	public ResponseEntity<AppException> handleSsaWebEx(SsaWebException ex){
		AppException appEx=new AppException();
		appEx.setExCode("EX0001");
		appEx.setExDesc(ex.getMessage());
		appEx.setDate(LocalDateTime.now());
		return new ResponseEntity<AppException>(appEx, HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
}
