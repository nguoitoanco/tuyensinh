//package admission.web.restcontroller;
//
//import admission.exception.CommonException;
//import admission.model.ws.Request;
//import admission.model.ws.Response;
//import co.jp.nej.earth.exception.EarthException;
//import co.jp.nej.earth.manager.session.EarthSessionManager;
//import co.jp.nej.earth.model.ws.Request;
//import co.jp.nej.earth.model.ws.Response;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//public abstract class BaseRestController {
//    private static final Logger LOG = LoggerFactory.getLogger(BaseRestController.class);
//
//    @Autowired
//    protected EMessageResource messageSource;
//    @Autowired
//    private ValidatorUtil validatorUtil;
//
//    @ControllerAdvice
//    private static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
//        JsonpAdvice() {
//            super("callback");
//        }
//    }
//
//    public interface WebServiceCaller {
//        Response getResponse() throws CommonException;
//    }
//
//    protected Response getRestResponse(Request request, BindingResult bindingResult, WebServiceCaller caller) {
//        Response response = new Response();
//        try {
//            LOG.info("Earth Spring Rest Webservice:");
//            LOG.info("Request Content:" + new ObjectMapper().writeValueAsString(request));
//
//            // Connecting session.
//            HttpSession session = EarthSessionManager.find(request.getSessionId());
//            if (session == null) {
//                response.setMessages(messageSource.get(ErrorCode.SESSION_INVALID, null));
//            } else {
//                // Validation data input.
//                List<Message> messages = validatorUtil.validate(bindingResult);
//                if (CollectionUtils.isEmpty(messages)) {
//                    response = caller.getResponse();
//                } else {
//                    response.setMessages(messages);
//                }
//            }
//        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
//            if(e instanceof CommonException && ((CommonException) e).getErrorMessage() != null) {
//                response.setMessages(((CommonException) e).getErrorMessage());
//            } else {
//                response.setMessages(e.getCause() + ":" + e.getMessage());
//            }
//        } finally {
//            try {
//                LOG.info("Response:" + new ObjectMapper().writeValueAsString(response));
//            } catch (JsonProcessingException e) {
//                LOG.info("JsonProcessingException:", e);
//            }
//        }
//        return response;
//    }
//}