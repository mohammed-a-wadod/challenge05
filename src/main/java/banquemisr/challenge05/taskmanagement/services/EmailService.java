package banquemisr.challenge05.taskmanagement.services;

import banquemisr.challenge05.taskmanagement.models.entites.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(Task task) throws Exception {
        String body = "<html><body><h2>Reminder: Task Due Soon!</h2>" +
                "<p>Dear,</p><p>This is a reminder that the following task is due soon:</p>" +
                "<ul>" +
                "<li><strong>Task:</strong>" + task.getTitle() + "</li>" +
                "<li><strong>Description:</strong>" + task.getDescription() + "</li>" +
                "<li><strong>Due Date:</strong>" + task.getDueDate().toLocalDate() + "</li>" +
                "<li><strong>Due Date:</strong>" + task.getDueDate() + "</li>" +
                "</ul>" +
                "<p>Please make sure to complete it by the specified due date.</p>" +
                "<p>Thank you,</p>" +
                "</body></html>";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setSubject("Reminder: Task Due Soon!");
        helper.setText(body, true);
        helper.setTo(task.getUserTaskMail());
        javaMailSender.send(mimeMessage);
    }
}
