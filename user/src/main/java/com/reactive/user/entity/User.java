package com.reactive.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class User {
    @Id
    @Column("user_id")
    private int id;

    @Column("user_name")
    private String name;

    @Column("user_email")
    private String email;

    @Column("user_address")
    private String address;
}
