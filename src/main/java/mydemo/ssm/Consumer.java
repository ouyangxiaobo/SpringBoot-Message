package mydemo.ssm;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;



/**
 * @Author ouyang
 * @Description //TODO
 * @Date 16:38 2019/6/24
 **/
@Component
public class Consumer {

    @Resource(name="smsUtils")

    private SmsUtils smsUtils;

    @JmsListener(destination = "sms-demo")
    public void task2(Map<String,String> map){

        try {
            SendSmsResponse smsResponse = smsUtils.sendSms(map);
            System.out.println("code:"+smsResponse.getCode() + "message:"+smsResponse.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
        }

        System.out.println(map);

    }




}
