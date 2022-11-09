package com.example.fileuploadtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class FileTest {
    @Id
    @GeneratedValue
    private Long file_id;
    private String route_name;
    private Double latitude;
    private Double longitude;
    private String file;
}
