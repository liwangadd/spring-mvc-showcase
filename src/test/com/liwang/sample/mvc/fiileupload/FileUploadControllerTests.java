package com.liwang.sample.mvc.fiileupload;

import com.liwang.sample.mvc.AbstractContextControllerTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Nikolas on 2015/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadControllerTests extends AbstractContextControllerTests {

    @Test
    public void readString() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());
        webAppContextSetup(this.wac).build()
                .perform(fileUpload("/fileupload").file(file))
                .andExpect(model().attribute("message", "File 'orig' uploaded successfully"));
    }

}
