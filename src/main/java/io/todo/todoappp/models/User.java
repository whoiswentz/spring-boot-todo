package io.todo.todoappp.models;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Data
@Document("users")
public class User {
    @Id
    private final ObjectId id;

    @Indexed
    private final String email;
    private final String password;
}