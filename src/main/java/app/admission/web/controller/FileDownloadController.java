package app.admission.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Controller
public class FileDownloadController {

    private static final String INTERNAL_FILE = "helloworld.pdf";
    private static final String EXTERNAL_FILE_PATH =
            "D:\\GDRIVE\\MyProject\\tuyensinh\\src\\main\\webapp\\resources\\images\\helloworld.zip";


    @RequestMapping(value = {"/downloadPage"}, method = RequestMethod.GET)
    public String gotoDowloadPage(ModelMap model) {
        return "download/downloadPage";
    }

    /*
     * Download a file from
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere.
     */
    @RequestMapping(value = "/download/{type}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {

        File file = null;

        if (type.equalsIgnoreCase("internal")) {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        } else {
            file = new File(EXTERNAL_FILE_PATH);
        }

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition",
                String.format("inline; filename=\"" + file.getName() + "\""));


        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}