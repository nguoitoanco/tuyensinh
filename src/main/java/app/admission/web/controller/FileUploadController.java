package app.admission.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class FileUploadController {
    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "E:\\temp\\";

    @RequestMapping(value = {"/uploadFiles"}, method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {

        StringJoiner sj = new StringJoiner(" , ");

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            try {

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER);
                Files.write(path, bytes);

                sj.add(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String uploadedFileName = sj.toString();
        if (StringUtils.isEmpty(uploadedFileName)) {
            redirectAttributes.addFlashAttribute("message",
                    "Please select a file to upload");
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + uploadedFileName + "'");
        }

        return "redirect:/uploadStatus";

    }

    @RequestMapping(value = {"/uploadPage"}, method = RequestMethod.GET)
    public String uploadMultiPage() {
        return "upload/uploadPage";
    }

    @RequestMapping(value = {"/uploadStatus"}, method = RequestMethod.GET)
    public String uploadStatus() {
        return "upload/uploadStatus";
    }
}