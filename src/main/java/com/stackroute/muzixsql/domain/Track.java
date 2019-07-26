package com.stackroute.muzixsql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    @Value("${comment}")
    private String comment;

}