package com.spds.admin.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	ResponseHelper responseHelper;
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatusCode status, WebRequest request)
	{
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);
		//pageNotFoundLogger.warn(ex.getMessage());
		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(
			MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleMissingServletRequestPart(
			MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleHandlerMethodValidationException(
			HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}

	@Nullable
	protected ResponseEntity<Object> handleNoResourceFoundException(
			NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
			AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleErrorResponseException(
			ErrorResponseException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleMaxUploadSizeExceededException(
			MaxUploadSizeExceededException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Object[] args = {ex.getPropertyName(), ex.getValue()};
		String defaultDetail = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
		String messageCode = ErrorResponse.getDefaultDetailMessageCode(TypeMismatchException.class, null);
		ProblemDetail body = createProblemDetail(ex, status, defaultDetail, messageCode, args, request);

		return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);
		//ProblemDetail body = createProblemDetail(ex, status, "Failed to read request", null, null, request);
		//return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleHttpMessageNotWritable(
			HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//ProblemDetail body = createProblemDetail(ex, status, "Failed to write request", null, null, request);
		//return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleMethodValidationException(
			MethodValidationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String code="100";
		String message="Invalid Request body";
		Map<String,String> fieldsError=new HashMap<>();
		fieldsError.put("name", "cannot be null");
		
		return responseHelper.createErrorResponse(headers,status,fieldsError,code,message);

		//ProblemDetail body = createProblemDetail(ex, status, "Validation failed", null, null, request);
		//return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@Nullable
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

		if (request instanceof ServletWebRequest servletWebRequest) {
			HttpServletResponse response = servletWebRequest.getResponse();
			if (response != null && response.isCommitted()) {
				if (logger.isWarnEnabled()) {
					logger.warn("Response already committed. Ignoring: " + ex);
				}
				return null;
			}
		}

		if (body == null && ex instanceof ErrorResponse errorResponse) {
			body = errorResponse.updateAndGetBody(this.getMessageSource(), LocaleContextHolder.getLocale());
		}

		if (statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR) && body == null) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return createResponseEntity(body, headers, statusCode, request);
		//return createResponseEntity(body,headers,statusCode, request);
	}
	
	
	
	

}
