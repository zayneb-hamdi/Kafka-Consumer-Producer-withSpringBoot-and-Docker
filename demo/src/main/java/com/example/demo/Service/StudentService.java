package com.example.demo.Service;

import com.example.demo.Model.Bonus;
import com.example.demo.Model.Student;
import com.example.demo.repository.BonusRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private NotificationService notificationService;



    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student)
    {
        studentRepository.save(student);
    }

    @KafkaListener(topics = "bonus_topic", groupId = "my-group")
    public void listenBonusNotifications(String message) {

        System.out.println("Received bonus update: " + message);
        String email = "zanoubiahaamdi@gmail.com";
        String subject = "Bonus Update Notification";
        String text = "Dear student, \n\n" + message + "\n\nBest regards, Your School";

        try {
            notificationService.sendEmail(email, subject, text);
            System.out.println("Email sent successfully!");;
        } catch (Exception e) {
            System.out.println("Error while sending email: " + e.getMessage());;
        }


    }
}
