//package admission.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
///**
// * Created by KhanhNV on 2017/05/29.
// */
//@ControllerAdvice(basePackages = {"co.jp.nej.earth.web.controller"})
//public class GlobalControllerAdvice {
//    @Autowired
//    protected EMessageResource messageSource;
//
//    @Autowired
//    protected Helper helper;
//
//    @ModelAttribute
//    public void globalAttributes(Model model) {
//        model.addAttribute("h", helper);
//        model.addAttribute("e", messageSource);
//        model.addAttribute("buildInfo", helper.getBuildInfo());
//    }
//}
