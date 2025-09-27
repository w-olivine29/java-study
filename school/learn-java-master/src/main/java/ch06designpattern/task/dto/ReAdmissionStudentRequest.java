package ch06designpattern.task.dto;

import java.time.Year;

public record ReAdmissionStudentRequest(
        Long id,
        String name,
        int grade,
        String department,
        Year entrancedYear
) {
}
