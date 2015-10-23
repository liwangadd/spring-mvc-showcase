package com.liwang.sample.mvc.form;

import com.liwang.sample.mvc.utils.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Nikolas on 2015/10/23.
 */
@Controller
@RequestMapping("/form")
@SessionAttributes("fromBean")
public class FormController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    @ModelAttribute("formBean")
    public FormBean createFormBean() {
        return new FormBean();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void form() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@Valid FormBean formBean, BindingResult result,
                                @ModelAttribute("ajaxRequest") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return null;
        }
        String message = "Form submitted successfully.  Bound " + formBean;
        if (ajaxRequest) {
            model.addAttribute("message", message);
            return null;
        } else {
            redirectAttrs.addFlashAttribute("message", message);
            return "redirect:/form";
        }
    }

}
