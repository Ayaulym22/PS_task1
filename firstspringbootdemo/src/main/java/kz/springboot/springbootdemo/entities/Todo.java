package kz.springboot.springbootdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "t_todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 200)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "addedDate")
    private String addedDate;

    @Column(name = "priority")
    private String  priority;


}
