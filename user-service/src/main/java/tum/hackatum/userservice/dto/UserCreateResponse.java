package tum.hackatum.userservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class UserCreateResponse {

    private String response;
    private HttpStatus httpStatus;

}
