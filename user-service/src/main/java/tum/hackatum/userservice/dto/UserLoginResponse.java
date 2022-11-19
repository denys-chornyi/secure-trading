package tum.hackatum.userservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class UserLoginResponse {

    private String response;
    private HttpStatus httpStatus;

}
