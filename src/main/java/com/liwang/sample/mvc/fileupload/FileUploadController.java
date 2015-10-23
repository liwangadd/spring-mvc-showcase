package com.liwang.sample.mvc.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nikolas on 2015/10/23.
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        String requestedWith = request.getHeader("X-Requested-With");
        boolean isAjaxRequest = requestedWith != null && "XMLHttpRequest".equals(requestedWith);
        model.addAttribute("ajaxRequest", isAjaxRequest);
    }

    @RequestMapping(method = RequestMethod.GET)
    public void fileUploadForm() {

    }

    @RequestMapping(method = RequestMethod.POST)
    public void processUpload(@RequestParam MultipartFile file, Model model) {
        model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
    }

}
