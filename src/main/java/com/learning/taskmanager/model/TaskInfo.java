package com.learning.taskmanager.model;

import lombok.*;

//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskInfo {
    private String title;
    private String description;
}
