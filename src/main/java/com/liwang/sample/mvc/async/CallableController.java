package com.liwang.sample.mvc.async;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * Created by Nikolas on 2015/10/23.
 */
@Controller
@RequestMapping("/async/callable")
public class CallableController {

    @RequestMapping("/response-body")
    public Callable<String> ccallable() {
        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };
    }

    @RequestMapping("/view")
    public Callable<String> callableWithView(final Model model) {
        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                model.addAttribute("foo", "bar");
                model.addAttribute("fruit", "apple");
                return "views/html";
            }
        };
    }

    @RequestMapping("exception")
    public Callable<String> callableWithException(@RequestParam(required = false, defaultValue = "true")
                                                  final boolean handled) {
        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                if (handled) {
                    throw new IllegalStateException("Callable error");
                } else {
                    throw new IllegalArgumentException("Callable error");
                }
            }
        };
    }

    @RequestMapping("/custom-timeout-handing")
    public
    @ResponseBody
    WebAsyncTask<String> callableWithCustomTimeoutHanding() {
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };
        return new WebAsyncTask<String>(1000, callable);
    }

    @ExceptionHandler()
    public
    @ResponseBody
    String handleException(IllegalStateException ex) {
        return "Handled exception: " + ex.getMessage();
    }

}
