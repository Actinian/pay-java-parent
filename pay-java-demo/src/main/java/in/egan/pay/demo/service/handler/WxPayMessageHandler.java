package in.egan.pay.demo.service.handler;

import in.egan.pay.common.api.PayService;
import in.egan.pay.common.bean.PayMessage;
import in.egan.pay.common.bean.PayOutMessage;
import in.egan.pay.common.exception.PayErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by ZaoSheng on 2016/6/1.
 */
public class WxPayMessageHandler extends BasePayMessageHandler {




    public WxPayMessageHandler(Integer payId) {
        super(payId);
    }

    @Override
    public PayOutMessage handle(PayMessage payMessage, Map<String, Object> context, PayService payService) throws PayErrorException {
        //交易状态
        if ("SUCCESS".equals(payMessage.getResultCode())){
            /////这里进行成功的处理

            return PayOutMessage.XML().code("Success").content("成功").build();
        }

        return PayOutMessage.XML().code("Fail").content("失败").build();
    }
}
