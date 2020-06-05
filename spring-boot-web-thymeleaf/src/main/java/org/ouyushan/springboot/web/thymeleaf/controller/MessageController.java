package org.ouyushan.springboot.web.thymeleaf.controller;

import org.ouyushan.springboot.web.thymeleaf.entity.Message;
import org.ouyushan.springboot.web.thymeleaf.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/29 14:42
 */
@Controller
@RequestMapping("/")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * http://localhost:8080/1
     */

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Message message) {
        return new ModelAndView("messages/view", "message", message);
    }

    /**
     * http://localhost:8080/?form
     * @param message
     * @return
     */
    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Message message) {
        return "messages/form";
    }

    /**
     *
     * @param message
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping
    public ModelAndView create(@Valid Message message, BindingResult result,
                               RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("messages/form", "formErrors", result.getAllErrors());
        }
        message = this.messageRepository.save(message);
        redirect.addFlashAttribute("globalMessage", "view.success");
        return new ModelAndView("redirect:/{message.id}", "message.id", message.getId());
    }

    @RequestMapping("foo")
    public String foo() {
        throw new RuntimeException("Expected error in controller");
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        this.messageRepository.deleteMessage(id);
        Iterable<Message> messages = this.messageRepository.findAll();
        return new ModelAndView("messages/list", "messages", messages);
    }

    @GetMapping("modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Message message) {
        return new ModelAndView("messages/form", "message", message);
    }

}
