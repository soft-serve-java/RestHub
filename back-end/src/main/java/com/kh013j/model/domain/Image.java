package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "image", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @SequenceGenerator(name = "image-sequence_generator", sequenceName = "image_sequence")
    @GeneratedValue(generator = "image-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    private String url;
}
