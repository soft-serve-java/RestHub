package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag", schema = "rh")
public class Tag {
    @Id
    @SequenceGenerator(name = "tag-sequence_generator", sequenceName = "tag_sequence")
    @GeneratedValue(generator = "tag-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=2, max=30)
    private String title;

    public Tag(@Size(min = 1, max = 30) String title) {
        this.title = title;
    }
}
