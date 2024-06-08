package br.com.andersonleite.animelinkapi.handler;

import br.com.andersonleite.animelinkapi.exception.BadRequestException;
import br.com.andersonleite.animelinkapi.exception.BadRequestExceptionDetails;
import br.com.andersonleite.animelinkapi.exception.ValidationExceptionDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestExceptionHandlerTest {

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    private final RestExceptionHandler restExceptionHandler = new RestExceptionHandler();

    @Test
    public void testHandlerBadRequestException() {
        BadRequestException badRequestException = new BadRequestException("Invalid request");

        ResponseEntity<BadRequestExceptionDetails> responseEntity = restExceptionHandler.handlerBadRequestException(badRequestException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Bad Request Exception, Check the Documentation", responseEntity.getBody().getTitle());
        assertEquals("Invalid request", responseEntity.getBody().getDetails());
        assertEquals(BadRequestException.class.getName(), responseEntity.getBody().getDeveloperMessage());
    }

    @Test
    public void testHandlerMethodArgumentNotValidException() {
        // Criando um mock de BindingResult e configurando com os erros desejados
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(
                new FieldError("objectName1", "field1", "defaultMessage1"),
                new FieldError("objectName2", "field2", "defaultMessage2")
        ));

        // Criando uma instância real de MethodArgumentNotValidException e configurando o BindingResult
        MethodArgumentNotValidException methodArgumentNotValidException =
                new MethodArgumentNotValidException(null, bindingResult);

        // Executando o método a ser testado
        ResponseEntity<ValidationExceptionDetails> responseEntity =
                restExceptionHandler.handlerMethodArgumentNotValidException(methodArgumentNotValidException);

        // Verificando as asserções
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Bad Request Exception, Invalid Fields", responseEntity.getBody().getTitle());
        assertEquals("Check the field(s) error", responseEntity.getBody().getDetails());
        assertEquals(MethodArgumentNotValidException.class.getName(), responseEntity.getBody().getDeveloperMessage());
        assertEquals("field1, field2", responseEntity.getBody().getFields());
        assertEquals("defaultMessage1, defaultMessage2", responseEntity.getBody().getFieldsMessage());
    }
}
