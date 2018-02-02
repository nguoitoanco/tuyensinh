package app.admission.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final int MAX_UPLOAD_SIZE_MB = 5 * 1024 * 1024; // 5 MB

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        MAX_UPLOAD_SIZE_MB, MAX_UPLOAD_SIZE_MB * 2, MAX_UPLOAD_SIZE_MB / 2);

        registration.setMultipartConfig(multipartConfigElement);

    }
}