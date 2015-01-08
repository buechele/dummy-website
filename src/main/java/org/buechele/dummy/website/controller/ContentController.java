package org.buechele.dummy.website.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by andreas on 08.01.15.
 */
@RestController
public class ContentController {

    @RequestMapping("/content/size/{size}")
    public void size(@PathVariable(value = "size") long size, HttpServletResponse response) throws IOException, InterruptedException {
        sizeSleep(size, 0, response);
    }

    @RequestMapping("/content/size/{size}/sleep/{sleep}")
    public void sizeSleep(@PathVariable("size") long size, @PathVariable("sleep") long sleep, HttpServletResponse response) throws IOException, InterruptedException {
        PrintWriter writer = response.getWriter();
        for (long i = 0; i < size; i++) {
            writer.print(String.valueOf(i % 10));
        }

        Thread.sleep(sleep);

        writer.flush();
        writer.close();
    }

}