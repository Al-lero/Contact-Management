package com.todo.organizer.dto.response;

import com.todo.organizer.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseApi {
    private boolean isSuccessful;
    private Object data;


}
