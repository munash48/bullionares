package com.kalimagezi.billionareskb.email;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class MailService {
	 @Autowired
	    private JavaMailSender emailSender;

	    @Autowired
	    private Configuration freemarkerConfig;

	    public void sendSimpleMessage(Mail mail, Map <String, Object> model) throws MessagingException, IOException, TemplateException {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());
	      

	       // helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

	        Template t = freemarkerConfig.getTemplate("email-template.ftl");
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

	        helper.setTo(mail.getTo());
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	        emailSender.send(message);
	        
	        
	    }

}
